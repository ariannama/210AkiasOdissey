<<<<<<< HEAD
=======

>>>>>>> 2d548679fab2c8fef192409511a92ad8b57f4188
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public abstract class Character extends Entity{

    private int damage;
    private int moveSpeed;
    private double currentHealth;
    private int maxHealth;

<<<<<<< HEAD
    public Character(Sprite s, String id,  int dmg, int mS, double cH, int maxH){
        super(s, id);
=======
    public Character(Sprite s, Texture t, String id,  int dmg, int mS, double cH, int maxH){
        super(s, t, id);
>>>>>>> 2d548679fab2c8fef192409511a92ad8b57f4188
        this.damage = dmg;
        this.moveSpeed = mS;
        this.currentHealth = cH;
        this.maxHealth = maxH;
    }

    public abstract void move();

<<<<<<< HEAD
=======
    public abstract void attack();

>>>>>>> 2d548679fab2c8fef192409511a92ad8b57f4188
    public void calcMove(){
        float x = getSpriteX();
        float y = getSpriteY();

<<<<<<< HEAD
        int dx = 2;
        int dy = 2;
=======
        int dx = 5;
        int dy = 5;
>>>>>>> 2d548679fab2c8fef192409511a92ad8b57f4188

        x += dx;
        y += dy;

        //LEFT
        if (x <= 35)
        { dx *= 2; sprite.setPosition(x , getSpriteY()); }

        //RIGHT
        if (x >= 950)
        { dx *= -2;  sprite.setPosition(x + dx , getSpriteY()); }

        //TOP
        if (y <= 0)
        {dy *= 2;  sprite.setPosition(getSpriteX() ,y);}

        //BOTTOM
        if (y >= 630)
        { dy *= -2;  sprite.setPosition(getSpriteX() ,y + dy); }


    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDamage() { return damage; }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 2d548679fab2c8fef192409511a92ad8b57f4188
