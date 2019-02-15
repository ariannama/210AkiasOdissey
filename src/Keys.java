import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
/*
* <h1>Keys</h1>
*
*  This is the key class
*
*  @Author Michael Heaver
*/

public class Keys extends Collectibles {

    public void pickUp(){
        despawnCollectible();
    }

    public Keys(Sprite key, Texture keyTexture,  float x, float y){
        super(key, keyTexture,"key");
        key.setPosition(x,y);
    }
}
