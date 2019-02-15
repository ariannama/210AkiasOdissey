import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

/*
 * <h1>FullHeart</h1>
 *
 *  This is the full heart class
 *
 *  @Author Michael Heaver
 */

public class FullHeart extends Collectibles {

    public void pickUp(){
        despawnCollectible();
    }

    public FullHeart(Sprite heart, Texture heartTexture,  float x, float y){
        super(heart, heartTexture,"coin");
        heart.setPosition(x,y);
    }
}
