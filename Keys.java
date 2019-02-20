import org.jsfml.graphics.Texture;
import java.nio.file.Paths;

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
     * @param t is the blank texture where it is overwritten to be the correct
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     */
    public Keys(Texture t,  float x, float y){
        super(t,"key");
        this.sprite.setPosition(x,y);
        try{
            t.loadFromFile(Paths.get("..\\images\\key.png"));
        }
        catch (Exception e){
            System.out.println("Key failed to load" + e);
        }
        this.sprite.setTexture(t);
    }
}