import org.jsfml.graphics.Texture;
import java.nio.file.Paths;

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
     * @param t is the blank texture where it is overwritten to be the correct
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     */
    public Coin(Texture t, float x, float y){
        super(t,"coin");
        this.sprite.setPosition(x,y);
        try{
            t.loadFromFile(Paths.get("..\\images\\coin.png"));
        }
        catch (Exception e){
            System.out.println("Coin failed to load" + e);
        }
        this.sprite.setTexture(t);
    }
}
