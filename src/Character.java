
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public abstract class Character extends Entity{

    private int damage;
    private int moveSpeed;
    protected double currentHealth;
    private int maxHealth;

    public Character(Texture t, int dmg, int mS, double cH, int maxH){
        super(t);
        this.damage = dmg;
        this.moveSpeed = mS;
        this.currentHealth = cH;
        this.maxHealth = maxH;
    }

    public abstract void move();

    public abstract void attack();

    public void calcMove(){
        float x = getSpriteX();
        float y = getSpriteY();

        int dx = 5;
        int dy = 5;

        x += dx;
        y += dy;

        //LEFT
        if (x <= 35)
        { dx *= 2; s.setPosition(x , getSpriteY()); }

        //RIGHT
        if (x >= 950)
        { dx *= -2;  s.setPosition(x + dx , getSpriteY()); }

        //TOP
        if (y <= 0)
        {dy *= 2;  s.setPosition(getSpriteX() ,y);}

        //BOTTOM
        if (y >= 630)
        { dy *= -2;  s.setPosition(getSpriteX() ,y + dy); }


    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public void setMoveSpeed(int moveSpeed)
    {
        this.moveSpeed = moveSpeed;
    }

    public void setCurrentHealth(double currentHealth)
    {
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getMoveSpeed()
    {
        return moveSpeed;
    }

    public double getCurrentHealth()
    {
        return currentHealth;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }
}
