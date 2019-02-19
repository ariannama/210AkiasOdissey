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

    /*
     * This method despawns the collectible by sending it off screen and setting to inactive
     */
    public void pickUp(){
        despawnCollectible();
    }

    /*
     * This is the constructor method for full heart
     * @param s is the sprite you will be using
     * @param t is the texture you will be using
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     */
    public FullHeart(Sprite s, Texture t,  float x, float y){
        super(s, t,"fullHeart");
        s.setPosition(x,y);
    }
}
