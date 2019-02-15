import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
/*
*   <h1>Items</h1>
*
*   Items are interactible non character entities these include
*   collectibles, weapons and scrolls
*
* @Author Michael Heaver
 */


public class Items extends Entity{

    /*
        This is the main constructor it requires x and y coordinates and the item id
     */
    private Boolean inactive;

    public void collision(){}

    //Converts the item to being inactive
    public void setInactive(){
        this.inactive=true;
    }

    public Items(Sprite sprite, Texture texture, String id){
        super(sprite,texture,id);
        this.inactive=false;
    }
}
