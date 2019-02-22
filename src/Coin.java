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

    /*
     * This method is the pickup method for coins
     */
    public void pickUp(){
        despawnCollectible();
    }

    /*
     * This is the constructor method for coin
     * @param s is the sprite you will be using
     * @param t is the texture you will be using
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     */
    public Coin(Sprite s, Texture t,  float x, float y){
        super(s, t,"coin");
        s.setPosition(x,y);
    }
}