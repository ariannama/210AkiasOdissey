import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class Keys extends Collectibles{
    private String imagePath="whatever the fuck it is";
    private int id;

    public String getImagePath(){
        return imagePath;
    }

    public int getID(){
        return id;
    }

    public void pickUp(){
        despawnCollectible();
    }

    public Keys(Sprite key, Texture texture , int x, int y){
        super(key, texture,"key");
        sprite.setPosition(x,y);

    }

}
