import org.jsfml.graphics.Texture;
import java.nio.file.Paths;
import java.util.Random;


/*
 * <h1>Scroll</h1>
 *
 *  This is the Scroll class
 *
 *  @Author Michael Heaver
 */

public class Scroll extends  Items{
    private int scrollNumber;
    private Items[] scrollItems;

    /*
     * This method will use up the scroll and depending on the scroll number
     * gives a different output
     */
    public void useScroll(){
        if(!getInactive()){
            Random rand = new Random();
            int n;
            Texture blank = new Texture();
            try{
                blank.loadFromFile(Paths.get("..\\images\\blank.png"));
            }catch(Exception e){
                System.out.println("Blank failed to load" + e);
            }
            if(scrollNumber==1){
                // Spawn 2 hearts
                for(int i=0;i<2;i++){
                    scrollItems[i] = new FullHeart(blank,(460+(i*80)),350);
                }
            }else if(scrollNumber==2) {
                // Spawn 5 coins
                for(int i=0;i<5;i++){
                    scrollItems[i]= new Coin(blank,(460+(i*20)),(310+(i*20)));
                }
            }else if(scrollNumber==3) {
                // Spawn a weapon
                n = rand.nextInt(8)+1;
                scrollItems[0] = new Weapons(blank,500,350,n);
            }else {
                // Spawn 2 passives
                for(int i=0;i<2;i++){
                    n = rand.nextInt(5)+1;
                    scrollItems[i] = new Passives(blank,(460 +(i*80)),350, n);
                }
            }
        }
    }

    /*
    * Returns the array of items spawned by the scroll
     */
    public Items[] getScrollItems(){
        return scrollItems;
    }

    /*
    *   This method picks up the scroll and leaves the pedestal
     */
	@Override
    public void pickup(){
        Texture itemPedestal = new Texture();
        try{
            itemPedestal.loadFromFile(Paths.get("..\\images\\itemPedestal.png"));
        }
        catch (Exception e){
            System.out.println("itemPedestal failed to load" + e);
        }
        setInactive();
    }

    /*
     * This is the constructor method for Scrolls
     * @param t is the blank texture which is changed to the correct texture
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     * @param scrollNum is the scroll number that has different results relative to its number
     */
    public Scroll(Texture t, float x, float y, int scrollNum){
        super(t,"Scroll");
		Texture nt = new Texture();
        this.scrollNumber = scrollNum;
        try{
            nt.loadFromFile(Paths.get("..\\images\\scrollPedestal.png"));
        }
        catch (Exception e){
            System.out.println("Scroll pedestal failed to load" +e);
        }
        this.sprite.setTexture(nt);
		super.resize(this.sprite);
		this.sprite.setPosition(x,y);
    }
}
