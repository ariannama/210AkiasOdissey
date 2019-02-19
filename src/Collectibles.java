import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
/*
*
* This is all collectible items such as keys, coins and hearts
* and disappear when collected
*
* @Author Michael Heaver
 */

public class Collectibles extends Items{
        /*
    * Main constructor
    * Takes the Sprite, Texture and String ID
    */
    public Collectibles(Sprite sprite, Texture texture, String id){
        super(sprite,texture, id);
    }

    public void collision(){}

    public void despawnCollectible(){
        this.sprite.setPosition(4000000,4000000);
        setInactive();
    }

    //Hearts
    public void collectHealth(){
       /*
       if(characters.currentHealth < characters.maxHealth){
            if(fullHeart){
                characters.currentHealth+fullHeart;
                if(characters.currentHealth>characters.maxHealth){
                    characters.currentHealth = characters.maxHealth;
                }
            }
            characters.currentHealth+halfHeart;
        }
        */
    }

}