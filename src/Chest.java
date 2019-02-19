import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/*
 * <h1>Chest</h1>
 *
 *  This is the Chest class
 *
 *  @Author Michael Heaver
 */
public class Chest extends Items {
    Boolean locked;
    Items[] chestItems;

    /*
    *   This method returns whether the chest is locked or not to use keys on them
     */
    public boolean getLocked(){
        return locked;
    }

    /*
    *  This is the pickup method this method checks if it locked or not which
    *  changes the chances for item drops from the chest. It also changes the
    *  visuals of the chest to be open and sets to inactive if opened
     */
    public void pickup(){
        if(getInactive()==false) {
            if (locked == true) {
                this.id = "openLockedChest";
                Path path = Paths.get("C:\\Users\\sony\\Documents\\210images\\openLockedChest.png");
                try {
                    this.texture.loadFromFile(path);
                } catch (Exception e) {
                    System.out.println(e);
                }
                chooseDropLocked();
                setInactive();
            } else {
                this.id = "openUnlockedChest";
                Path path = Paths.get("C:\\Users\\sony\\Documents\\210images\\openUnlockedChest.png");
                try {
                    this.texture.loadFromFile(path);
                } catch (Exception e) {
                    System.out.println(e);
                }
                chooseDropUnlocked();
                setInactive();
            }
        }
    }

    /*
     * This method spawns the items from the locked chest with increased chance for better loot
     */
    private void chooseDropLocked() {

        Random rand = new Random();
        int n = rand.nextInt(60);
        Texture coin = new Texture();
        Texture key = new Texture();
        Texture weapon = new Texture();
        Texture passive = new Texture();
        Texture hh = new Texture();
        Texture fh = new Texture();
        try{
            coin.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\coin.png"));
            key.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\key.png"));
            weapon.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\key.png"));
            passive.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\key.png"));
            hh.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\key.png"));
            fh.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\key.png"));
        }
        catch (Exception e){
            System.out.println(e);
        }

        if(n>0&&n<=20){
            //5 coins
            for(int i=0;i>5;i++){
                chestItems[i]=  new Coin(new Sprite(coin),coin,(this.sprite.getPosition().x+5+(5*-i)),(this.sprite.getPosition().y+5+(5*-i)));
            }
        }else if(n>20&&n<=30){
            //Key
            chestItems[0]= new Keys(new Sprite(key),key,(this.sprite.getPosition().x+5+(5)),(this.sprite.getPosition().y+10));

        }else if(n>30&&n<=40){
            //Weapon
            int id = rand.nextInt(8);
            chestItems[0]= new Weapons(new Sprite(weapon),weapon,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10),id);

        }else if(n>40&&n<=50){
            //Passive
            int id = rand.nextInt(5);
            chestItems[0]= new Passives(new Sprite(passive),passive,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10),id);

        }else if(n>50&&n<=55){
            //Half heart
            chestItems[0]= new HalfHeart(new Sprite(hh),hh,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10));

        }else {
            //Full heart
            chestItems[0]= new FullHeart(new Sprite(fh),fh,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10));

        }
    }

    /*
     * This method returns the item array of what spawned from the chest
     */
    public Items[] getChestItems(){
        return chestItems;
    }

    /*
     * This method spawns the items from the unlocked chest with increased chance for more coins
     */
    private void chooseDropUnlocked() {


        Random rand = new Random();
        int n = rand.nextInt(60);
        Texture coin = new Texture();
        Texture key = new Texture();
        Texture weapon = new Texture();
        Texture passive = new Texture();
        Texture hh = new Texture();
        Texture fh = new Texture();
        try{
            coin.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\coin.png"));
            key.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\key.png"));
            weapon.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\key.png"));
            passive.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\key.png"));
            hh.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\key.png"));
            fh.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\key.png"));
        }
        catch (Exception e){
            System.out.println(e);
        }

        if(n>0&&n<=25){
            //5 coins
            for(int i=0;i>5;i++){
                chestItems[i]=  new Coin(new Sprite(coin),coin,(this.sprite.getPosition().x+5+(5*-i)),(this.sprite.getPosition().y+5+(5*-i)));
            }
        }else if(n>25&&n<=35){
            //Key
            chestItems[0]= new Keys(new Sprite(key),key,(this.sprite.getPosition().x+5+(5)),(this.sprite.getPosition().y+10));

        }else if(n>35&&n<=40){
            //Weapon
            int id = rand.nextInt(8);
            chestItems[0]= new Weapons(new Sprite(weapon),weapon,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10),id);

        }else if(n>40&&n<=50){
            //Passive
            int id = rand.nextInt(5);
            chestItems[0]= new Passives(new Sprite(passive),passive,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10),id);

        }else if(n>50&&n<=55){
            //Half heart
            chestItems[0]= new HalfHeart(new Sprite(hh),hh,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10));

        }else {
            //Full heart
            chestItems[0]= new FullHeart(new Sprite(fh),fh,(this.sprite.getPosition().x+10),(this.sprite.getPosition().y+10));

        }
    }

    /*
     * This is the constructor method for chest
     * @param s is the sprite you will be using
     * @param t is the texture you will be using
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     * @param l is the boolean to find if the chest is locked or not
     */
    public Chest(Sprite s, Texture t, float x, float y, Boolean l){
        super(s,t,"closedChest");
        s.setPosition(x,y);
        this.locked = l;
        if(locked==true){
            this.id = "closedLockedChest";
        }
        else{ this.id = "closedUnlockedChest";}

    }
}
