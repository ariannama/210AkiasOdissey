<<<<<<< HEAD
=======
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.jsfml.graphics.RenderWindow;
>>>>>>> 2d548679fab2c8fef192409511a92ad8b57f4188
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

public class Player extends Character {

    private int coinCount;
    private int keyCount;
<<<<<<< HEAD
=======
    private RenderWindow w;


    private boolean firing = false;
>>>>>>> 2d548679fab2c8fef192409511a92ad8b57f4188
    //private Item currentItems = new Item[amountOfItems]; --> Change to list later
    //private Weapon currentWeapon;


    //private double percentageLuck;

    //Constructor with preset stats
<<<<<<< HEAD
    public Player(Sprite s, String id,  int dmg, int mS, double cH, int maxH, int coinCount, int keyCount) {
        super(s,  id, dmg, mS, cH, maxH);
        this.coinCount = coinCount;
        this.keyCount = keyCount;
    }



    public void move() {
        if(Keyboard.isKeyPressed(Keyboard.Key.UP))
        {
            sprite.move(0, -2);
            //sprite.setTexture(texture);
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.DOWN))
        {
            sprite.move(0, 2);
            //sprite.setTexture(texture);
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.LEFT))
        {
            sprite.move(-2, 0);
            // sprite.setTexture(texture);
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.RIGHT))
        {
            sprite.move(2, 0);
            //sprite.setTexture(texture);
        }
        if(Keyboard.isKeyPressed(Keyboard.Key.SPACE))
        {
        }
=======
    public Player(Sprite s, Texture t, String id,  int dmg, int mS, double cH, int maxH, int coinCount, int keyCount, RenderWindow w) {
        super(s, t, id, dmg, mS, cH, maxH);
        this.coinCount = coinCount;
        this.keyCount = keyCount;
        this.w = w;
    }

    public void move(){
>>>>>>> 2d548679fab2c8fef192409511a92ad8b57f4188
    }
    public void collision(){

    }
<<<<<<< HEAD

}
=======
    public void attack() {

    }
    public boolean isFiring(){
        return firing;
    }
    public void setFiring(boolean b){
        firing = b;
    }
    public void addCoin(){
        coinCount++;
    }
}
>>>>>>> 2d548679fab2c8fef192409511a92ad8b57f4188
