import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * <h1>Coin</h1>
 *
 *  This is the Chest class
 *
 *  @Author Michael Heaver
 */
public class Chest extends Items {
    Boolean locked;

    public void pickup(){
        if(locked == true){
            this.id = "openLockedChest";
            Path path = Paths.get("C:\\Users\\sony\\Documents\\210images\\openLolockedChest.png");
            try{
                this.texture.loadFromFile(path);}
            catch(Exception e){
                System.out.println(e);
            }

            chooseDropLocked();
        }else{
            this.id = "openUnlockedChest";
            Path path = Paths.get("C:\\Users\\sony\\Documents\\210images\\openUnlockedChest.png");
            try{
            this.texture.loadFromFile(path);}
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    private void chooseDropLocked() {
        if(rand>0&&rand<=20){
            //5 coins
        }else if(rand>20&&rand<=30){
            //Key
        }else if(rand>30&&rand<=40){
            //Weapon
        }else if(rand>40&&rand<=50){
            //Passive
        }else if(rand>50&&rand<=55){
            //Half heart
        }else {
            //Full heart
        }
    }

    private void chooseDropUnlocked() {
        if(rand>0&&rand<=25){
            //5 coins
        }else if(rand>25&&rand<=35){
            //Key
        }else if(rand>35&&rand<=40){
            //Weapon
        }else if(rand>4&&rand<=50){
            //Passive
        }else if(rand>50&&rand<=55){
            //Half heart
        }else {
            //Full heart
        }
    }


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
