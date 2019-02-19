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


    /*
     * This method despawns the collectible by sending it off screen and setting to inactive
     */
    public void pickUp(){
        despawnCollectible();
    }

    /*
     * This is the constructor method for keys
     * @param s is the sprite you will be using
     * @param t is the texture you will be using
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     */
    public Keys(Sprite s, Texture t,  float x, float y){
        super(s, t,"key");
        s.setPosition(x,y);
    }
}