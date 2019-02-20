import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

/*
* <h1>Collectibles<h/1>
*
* This is all collectible items such as keys, coins and hearts
* and disappear when collected
*
* @Author Michael Heaver
*/
public class Collectibles extends Items{

    /*
     * This method despawns the collectible by sending it off screen and setting to inactive
     */
    protected void despawnCollectible(){
        this.sprite.setPosition(4000000,4000000);
        setInactive();
    }

    /*
     * This is the constructor method for Collectibles
     * @param t is the texture you will be using
     * @param id is the string  id for what the collectible is
     */
    protected Collectibles(Texture t, String id){
        super(t,id);
    }
}