import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

/*
 * <h1>HalfHeart</h1>
 *
 *  This is the half heart class
 *
 *  @Author Michael Heaver
 */

public class HalfHeart extends Collectibles {

    public void pickUp(){
        despawnCollectible();
    }

    public HalfHeart(Sprite heart, Texture heartTexture,  float x, float y){
        super(heart, heartTexture,"coin");
        heart.setPosition(x,y);
    }
}

