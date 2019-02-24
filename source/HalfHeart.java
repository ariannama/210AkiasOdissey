import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

import java.nio.file.Paths;

/*
 * <h1>HalfHeart</h1>
 *
 *  This is the half heart class
 *
 *  @Author Michael Heaver
 */

public class HalfHeart extends Collectibles {

    /*
     * This method despawns the collectible by sending it off screen and setting to inactive
     */
	 @Override
    public void pickup(){
        despawnCollectible();
    }

    /*
     * This is the constructor method for half a heart
     * @param t is the blank texture which is overwritten with the correct texture
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     */
    public HalfHeart(Texture t,  float x, float y){
        super(t,"halfHeart");

		Texture nt = new Texture();
        try{
            nt.loadFromFile(Paths.get("..\\images\\halfHeart.png"));
        }
        catch (Exception e){
            System.out.println("Half heart failed to load" + e);
        }
        this.sprite.setTexture(nt);
		super.resize(this.sprite);
		this.sprite.setPosition(x,y);
    }
}

