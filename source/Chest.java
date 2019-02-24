import org.jsfml.graphics.Texture;
import java.nio.file.Paths;
import java.util.Random;
import java.util.ArrayList;
import org.jsfml.graphics.Sprite;
/*
 * <h1>Chest</h1>
 *
 *  This is the Chest class
 *
 *  @Author Michael Heaver
 */
public class Chest extends Items {
    private boolean locked;
    private ArrayList<Items> chestItems = new ArrayList<>();

    /*
    *   This method returns whether the chest is locked or not to use keys on them
     */
    public boolean getLocked(){
        return locked;
    }

    /*
     * This method returns the item array of what spawned from the chest
     */
    public ArrayList getChestItems(){
        return chestItems;
    }

    /*
    *  This is the pickup method this method checks if it locked or not which
    *  changes the chances for item drops from the chest. It also changes the
    *  visuals of the chest to be open and sets to inactive if opened
     */
	@Override
    public void pickup(){
        if(!getInactive()) {
			Texture nt = new Texture();
			System.out.println("Opening chest...");
            if (locked) {
                this.id = "openLockedChest";
                try {
					System.out.println("Loading image");
                    nt.loadFromFile(Paths.get("..\\images\\lockedChestOpen.png"));
                } catch (Exception e) {
                    System.out.print("OLC failed to load" + e);
                }
                chooseDropLocked();
            } else {
                this.id = "openUnlockedChest";
                try {
					System.out.println("Loading image");
                    nt.loadFromFile(Paths.get("..\\images\\unlockedChestOpen.png"));
                } catch (Exception e) {
                    System.out.println("OUC failed to load" + e);
                }
                chooseDropUnlocked();
            }
            setInactive();
			System.out.println("Setting sprite");
			this.sprite.setTexture(nt);
        }
    }

    /**
     * This method spawns the items from the locked chest with increased chance for better loot
     **/
    private void chooseDropLocked() {

        Random rand = new Random();
        int n = rand.nextInt(60);
        Texture blank = new Texture();
        try{
            blank.loadFromFile(Paths.get("..\\images\\blank.png"));
            }
        catch (Exception e){
            System.out.println("Blank failed to load" + e);
        }
        if(n>0&&n<=20){
            //5 coins
            for(int i=0;i<5;i++){
                chestItems.add(new Coin(blank,(this.sprite.getPosition().x+5+(5*-i)),(this.sprite.getPosition().y+5+(5*-i))));
            }
        }else if(n>20&&n<=30){
            //Key
            chestItems.add(new Keys(blank,(this.sprite.getPosition().x+5+(5)),(this.sprite.getPosition().y+10)));
        }else if(n>30&&n<=40){
            //Weapon
            int id = rand.nextInt(8);
            chestItems.add(new Weapons(blank,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10),id));
        }else if(n>40&&n<=50){
            //Passive
            int id = rand.nextInt(5);
            chestItems.add(new Passives(blank,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10),id));
        }else if(n>50&&n<=55){
            //Half heart
            chestItems.add(new HalfHeart(blank,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10)));
        }else {
            //Full heart
            chestItems.add(new FullHeart(blank,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10)));
        }
    }

    /**
     * This method spawns the items from the unlocked chest with increased chance for more coins
     **/
    private void chooseDropUnlocked() {


        Random rand = new Random();
        int n = rand.nextInt(60);
        Texture blank = new Texture();
        try{
            blank.loadFromFile(Paths.get("..\\images\\blank.png"));
        }
        catch (Exception e){
            System.out.println("Blank failed to load" + e);
        }
        if(n>0&&n<=25){
            //5 coins
            for(int i=0;i<5;i++){
                chestItems.add(new Coin(blank,(this.sprite.getPosition().x+5+(5*-i)),(this.sprite.getPosition().y+5+(5*-i))));
            }
        }else if(n>25&&n<=35){
            //Key
            chestItems.add(new Keys(blank,(this.sprite.getPosition().x+5+(5)),(this.sprite.getPosition().y+10)));
        }else if(n>35&&n<=40){
            //Weapon
            int id = rand.nextInt(8);
            chestItems.add(new Weapons(blank,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10),id));
        }else if(n>40&&n<=50){
            //Passive
            int id = rand.nextInt(5);
            chestItems.add(new Passives(blank,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10),id));
        }else if(n>50&&n<=55){
            //Half heart
            chestItems.add(new HalfHeart(blank,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10)));
        }else {
            //Full heart
            chestItems.add(new FullHeart(blank,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10)));
        }
    }

    /**
     * This is the constructor method for chest
     * @param t is the blank texture which will be updated with the correct texture
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     * @param l is the boolean to find if the chest is locked or not
     **/
    public Chest(Texture t, float x, float y, Boolean l){
        super(t,"closedChest");
        this.locked = l;
        Texture ut = new Texture();
        Texture lt = new Texture();
        try{
            ut.loadFromFile(Paths.get("..\\images\\unlockedChestClosed.png"));
            lt.loadFromFile(Paths.get("..\\images\\lockedChestClosed.png"));
        }catch (Exception e){
            System.out.println("Closed chest failed to load" + e);
        }
        if(locked){
            this.id = "closedLockedChest";
            this.sprite.setTexture(lt);
        }
        else {
            this.id = "closedUnlockedChest";
            this.sprite.setTexture(ut);
        }
		super.resize(this.sprite);
		this.sprite.setPosition(x,y);
    }
	
	public Sprite getItemSprite(){
		//System.out.println(i.sprite);
		return this.sprite;
	}
	
}
