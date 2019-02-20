import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

import java.nio.file.Paths;

/*
 * <h1>FullHeart</h1>
 *
 *  This is the full heart class
 *
 *  @Author Michael Heaver
 */

public class FullHeart extends Collectibles {

    /*
     * This method despawns the collectible by sending it off screen and setting to inactive
     */
    public void pickUp(){
        despawnCollectible();
    }

    /*
     * This is the constructor method for full heart
     * @param t is the blank texture which is overwritten with the correct texture
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     */
    public FullHeart(Texture t,  float x, float y){
        super(t,"fullHeart");
        this.sprite.setPosition(x,y);
        try{
            t.loadFromFile(Paths.get("..\\images\\fullHeart.png"));
        }
        catch (Exception e){
            System.out.println("Full Heart failed to load" + e);
        }
        this.sprite.setTexture(t);
    }
}
