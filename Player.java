
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

public class Player extends Character {

    private int coinCount;
    private int keyCount;
    //private Item currentItems = new Item[amountOfItems]; --> Change to list later
    //private Weapon currentWeapon;


    //private double percentageLuck;

    //Constructor with preset stats
    public Player(Sprite s, Texture t, String id,  int dmg, int mS, double cH, int maxH, int coinCount, int keyCount) {
        super(s, t, id, dmg, mS, cH, maxH);
        this.coinCount = coinCount;
        this.keyCount = keyCount;
    }

    public void move() {
        if(Keyboard.isKeyPressed(Keyboard.Key.UP))
        {
            sprite.move(0, -1);
            //sprite.setTexture(texture);
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.DOWN))
        {
            sprite.move(0, 1);
            //sprite.setTexture(texture);
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.LEFT))
        {
            sprite.move(-1, 0);
           // sprite.setTexture(texture);
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.RIGHT))
        {
            sprite.move(1, 0);
            //sprite.setTexture(texture);
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.SPACE))
        {
        }
    }
    public void collision(){

    }

}
