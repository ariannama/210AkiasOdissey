import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;


/*
 * <h1>Coin</h1>
 *
 *  This is the Scroll class
 *
 *  @Author Michael Heaver
 */

public class Scroll extends  Items{
    public Scroll(Sprite s, Texture t, float x, float y){
        super(s,t,"Scroll");
        s.setPosition(x,y);
    }
}
