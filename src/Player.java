import com.sun.org.apache.xpath.internal.operations.Bool;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

public class Player extends Character {

    private int coinCount;
    private int keyCount;
    private RenderWindow w;


    private boolean firing = false;
    //private Item currentItems = new Item[amountOfItems]; --> Change to list later
    //private Weapon currentWeapon;


    //private double percentageLuck;

    //Constructor with preset stats
    public Player(Texture t, RenderWindow window,  int dmg, int mS, double cH, int maxH, int coinCount, int keyCount) {
        super(t, window, dmg, mS, cH, maxH);
        this.coinCount = coinCount;
        this.keyCount = keyCount;
        this.w = w;
    }

    public void move(){

    }
    public void collision(){

    }
    public void attack() {

    }

    public Vector2f getX(){
        return s.getPosition();
    }
    public boolean isFiring(){
        return firing;
    }
    public void setFiring(boolean b){
        firing = b;
    }
    public void addCoin(){
        coinCount++;
        System.out.println(coinCount);
    }
    public void addKey() { keyCount++ ; }
}