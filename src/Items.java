import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

/*
*   <h1>Items</h1>
*
*   Items are interactible non character entities these include
*   chests, collectibles, passives, weapons and scrolls
*
* @Author Michael Heaver
*/
public class Items extends Entity{
    private Boolean inactive;


    /*
     * This method allows for all items to have collision detection
     */
    public void collision(){}

    /*
     * This method returns whether the item is inactive or not
     */
    public boolean getInactive(){return inactive;}

    /*
     *Converts the item to being inactive
     */
    public void setInactive(){
        this.inactive=true;
    }

    /*
     * This is the constructor method for Items
     * @param s is the sprite you will be using
     * @param t is the texture you will be using
     * @param id is the string id of the item
     * Also sets the item to be active
     */
    public Items(Sprite s, Texture t, String id){
        super(s,t,id);
        this.inactive=false;
    }
}
