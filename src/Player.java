import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
    <h1>Player</h1>
    This is the player class which has all the functions for movement
    attacking, and being attacked

    @Author Arianna, Michael, Olek
 **/
public class Player extends Character {

    private int coinCount, keyCount, projSpeed;
    private Weapons currentWeapon;
    private long fireRate;
    private boolean firing = false;
    private char direction;
    private boolean alive;
    private ArrayList<Projectile> projectiles;
    long startTime, endTime, totalTime;

    /**
        This is the constructor for player it takes
        @param: t is a texture of whatever the character sprite will look like
        @param: dmg is an integer which is the base damage of the player
        @param: mS is an integer which is the base movement speed of the player
        @param: maxH is an integer which is the base max health of the player
        @param: weapon is the starting weapon of the player
     **/
    public Player(Texture t, int dmg, int mS, int maxH, Weapons weapon) {
        super(t, dmg, mS, maxH);
        this.alive=true;
        this.coinCount = this.keyCount = 0;
        this.currentWeapon = weapon;
        this.fireRate = (1 + this.currentWeapon.weaponFireRate)*1000;
        this.firing = false;
        startTime = System.nanoTime() / 1000000;
        endTime = totalTime= 0;
        projSpeed = 10;
    }

    /**
        This returns the current weapon of the player
     **/
    public Weapons getCurrentWeapon() {
        return currentWeapon;
    }

    /**
        This swaps the current weapon
        @param: this is weapon that is becoming the current
        returns the old weapon
     **/
    public Weapons swapCurrentWeapon(Weapons newWeapon){
        Weapons oldWeapon = this.currentWeapon;
        this.currentWeapon = newWeapon;
        return oldWeapon;
    }

    /**
        This returns the total fire rate of the player
     **/
    public long getPlayerFireRate() {
        return this.fireRate;
    }

    /**
        This returns the total damage of the player
     **/
    public int getPlayerDamage() {
        int totalDamage = this.damage + this.currentWeapon.weaponDamage;
        return totalDamage;
    }

    /**
            This returns the maxHealth of the player
    **/
    public int getMaxHealth() {
        return this.maxHealth;
    }

    /**
        This returns the current health of the player
     **/
    public double getCurrentHealth() {

        return this.currentHealth;
    }
    /**
        This returns if the player is alive
     **/
    public boolean getAlive(){
        return alive;
    }

    /**
       This method allows movement of the player in all 4 directions and the texture
        depending on the the weapon and direction
    **/
    public void move(){
        Texture up = new Texture();
        Texture down = new Texture();
        Texture left = new Texture();
        Texture right = new Texture();

        try{
            up.loadFromFile(Paths.get("..\\images\\player" + currentWeapon.getWand()+"B.png"));
            down.loadFromFile(Paths.get("..\\images\\player" + currentWeapon.getWand()+"F.png"));
            left.loadFromFile(Paths.get("..\\images\\player" + currentWeapon.getWand()+"L.png"));
            right.loadFromFile(Paths.get("..\\images\\player" + currentWeapon.getWand()+"R.png"));
        }
        catch(Exception e){
            System.out.println("Player failed to load" + e);
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.ESCAPE))
        {
            this.alive = false;
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.W))
        {
            this.sprite.move(0, -this.moveSpeed);
            this.sprite.setTexture(up);
            direction = 'B';
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.S))
        {
            this.sprite.move(0, this.moveSpeed);
            this.sprite.setTexture(down);
            direction = 'F';
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.A))
        {
            this.sprite.move(-this.moveSpeed, 0);
            this.sprite.setTexture(left);
            direction = 'L';
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.D))
        {
            this.sprite.move(this.moveSpeed, 0);
            this.sprite.setTexture(right);
            direction = 'R';
        }
    }


    /**
     * This allows for collision with the player
     */
    public void collision(){

    }

    /**
     * This allows the player to attack in all directions and spawns the correct texture
     * it also checks if it can fire again as it is restricted to a firerate
     */
    public void attack() {
        Texture projectileTexture = new Texture(currentWeapon.getProjectile());
        float xProject=0, yProject=0;

        if(Keyboard.isKeyPressed(Keyboard.Key.UP))
        {
            firing=true;
            xProject = 0;
            yProject = -projSpeed;
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.DOWN))
        {
            firing=true;
            xProject = 0;
            yProject = projSpeed;
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.LEFT))
        {
            firing=true;
            xProject = -projSpeed;
            yProject = 0;
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.RIGHT))
        {
            firing=true;
            xProject = projSpeed;
            yProject = 0;
        }
        endTime = System.nanoTime() / 1000000;
        totalTime = endTime - startTime;
        if (totalTime > fireRate && firing) {
            startTime = System.nanoTime() / 1000000;
            Projectile spell = new Projectile(projectileTexture, new Vector2f(xProject, yProject));
            spell.sprite.setPosition(this.sprite.getPosition());
            projectiles.add(spell);
            firing = false;
        }
    }

    /**
     * This method reduces player health depending on the enemy
     * @param: enemy this is the enemy that has damaged the play either melee or range
     * If health is dropped to 0 or less game over return to menu
     */
    public void takeDamage(int enemyDmg){
        currentHealth = currentHealth - enemyDmg;
        Texture damaged = new Texture();
        Texture currentTexture = this.t;
        try{
            damaged.loadFromFile(Paths.get("..\\images\\playerD"+ currentWeapon.getWand() + direction +".png"));
        }
        catch (Exception e){
            System.out.println("Damaged failed to load " + e);
        }
        this.sprite.setTexture(damaged);

        this.sprite.setTexture(currentTexture);

        if(currentHealth <= 0) {
            this.sprite.setPosition(4000,4000);
            this.alive = false;
        }
    }

    /**
     * @return: the players x and y position
     */
    public Vector2f getPlayerPos(){
        return sprite.getPosition();
    }

    /**
     * Increases firerate by 250 which is 1 shot per 4 seconds increase
     */
    public void increaseFireRate(){this.fireRate += 250;}

    /**
     * Increases damage by 1
     */
    public void increaseDamage(){this.damage += 1;}

    /**
     * Increases Max health by 10 which is 1 heart
     */
    public void increaseMaxHealth(){this.maxHealth += 10;}

    /**
     * Increases projectile speed by 0.5
     */
    public void increaseProjSpeed(){this.projSpeed += 0.5;}

    /**
     * Increases move speed by 1
     */
    public void increaseMovementSpeed(){this.moveSpeed += 1;}

    /**
     * Increases coin count by 1
     */
    public void addCoin(){
        coinCount++;
    }

    /**
     * Increases key count by 1
     */
    public void addKey() { keyCount++ ; }
}
