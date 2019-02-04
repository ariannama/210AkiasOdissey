import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public abstract class Character extends Entity{

    private int damage;
    private int moveSpeed;
    private double currentHealth;
    private int maxHealth;

    public Character(Sprite s, Texture t, String id,  int dmg, int mS, double cH, int maxH){
        super(s, t, id);
        this.damage = dmg;
        this.moveSpeed = mS;
        this.currentHealth = cH;
        this.maxHealth = maxH;
    }

    public abstract void move();

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

    public int getDamage() {

        return damage;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
