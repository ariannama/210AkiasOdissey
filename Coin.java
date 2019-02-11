import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

/*
  * <h1>Coin</h1>
  *
  *  This is the coin class
  *
  *  @Author Michael Heaver
*/
public class Coin extends Collectibles {

    public Coin(Sprite coin, Texture coinTexture,  float x, float y){
        super(coin, coinTexture,"coin");
        sprite.setPosition(x,y);

    }
}
