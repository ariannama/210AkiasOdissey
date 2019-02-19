import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public abstract class Enemy extends Character
{
    public Enemy(Sprite s, Texture t, String id, int dmg, int mS, double cH, int maxH)
    {
        super(s, t, id, dmg, mS, cH, maxH);
    }

    public void attack() 
    {

    }

    public void move() 
    {

    }
}