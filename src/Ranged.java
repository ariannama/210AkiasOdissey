import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class Ranged extends Character {
    public Ranged(Sprite s, Texture t, String id, int dmg, int mS, double cH, int maxH){
        super(s, t, id, dmg, mS, cH, maxH);
    }
    public void attack(){}
    public void move(){}
    public void collision(){}
}
