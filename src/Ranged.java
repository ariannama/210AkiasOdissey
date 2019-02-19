import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class Ranged extends Enemy 
{
    public Ranged(Sprite s, Texture t, String id, int dmg, int mS, double cH, int maxH)
    {
        super(s, t, id, dmg, mS, cH, maxH);
    }
    public void collision(){}

    public void setCurrentHealth(){
        this.currentHealth -=0.5;
    }
}
