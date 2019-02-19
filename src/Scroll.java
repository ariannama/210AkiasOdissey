import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

import java.nio.file.Paths;


/*
 * <h1>Scroll</h1>
 *
 *  This is the Scroll class
 *
 *  @Author Michael Heaver
 */

public class Scroll extends  Items{
    int scrollNumber;

    /*
    * This method will use up the scroll and depending on the scroll number
    * gives a different output
     */
    public void useScroll(){
        // Need to come up with some ideas

    }

    /*
    *   This method picks up the scroll and leaves the pedestal
     */
    public void pickup(){
        Texture itemPedestal = new Texture();
        try{
            itemPedestal.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\itemPedestal.png"));
        }
        catch (Exception e){
            System.out.println(e);
        }
        setInactive();
    }

    /*
     * This is the constructor method for Scrolls
     * @param s is the sprite you will be using
     * @param t is the texture you will be using
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     * @param scrollNum is the scroll number that has different results relative to its number
     */
    public Scroll(Sprite s, Texture t, float x, float y, int scrollNum){
        super(s,t,"Scroll");
        s.setPosition(x,y);
        this.scrollNumber = scrollNum;
    }
}
