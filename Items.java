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
    protected String id;



    /*
     * This method allows for all items to have collision detection
     */
    public void collision(){}

    /*
     * This method returns whether the item is inactive or not
     */
    protected boolean getInactive(){return inactive;}

    /*
     *Converts the item to being inactive
     */
    protected void setInactive(){
        this.inactive=true;
    }

    /*
     * This is the constructor method for Items
     * @param t is the texture of the sprite we shall be using
     * @param id is the string id of the item
     * Also sets the item to be active
     */
    protected Items(Texture t, String id){
        super(t);
        this.id = id;
        this.inactive=false;
    }
}
