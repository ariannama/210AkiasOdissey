import org.jsfml.graphics.Texture;
import org.jsfml.graphics.Sprite;

import java.nio.file.Paths;

/*
 * <h1>Weapon</h1>
 *
 *  This is the Weapons class
 *
 *  @Author Michael Heaver
 */
public class Weapons extends Items{
    /*
    CSV file of weapons list with list of stat boosts
    method for dropping equipped and spawning it in the room and replacing with picked up
    scroll may have its own class as each would have id number to link to its desired effect
     */
    int weaponDamage;
    int weaponFireRate;
    private boolean wand;
    private Element element;

    /*
    * These are the four elements
     */
    private enum Element{
        WATER, EARTH, FIRE, WIND
    }

    /*
    * Returns an integer value depending on the element
     */
    public int getElement(){
        if(Element.WATER == element) {
            return 0;
        }else if(Element.EARTH == element){
            return 1;
        }else if(Element.FIRE == element){
            return 2;
        }else{return 3;}
    }

    /*
     * This is the constructor method for Weapons
     * @param s is the sprite you will be using
     * @param t is the texture you will be using
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     * @param weaponNum is the weapon number that has different weapon relative to its number
     */
    public Weapons(Sprite newWeapon, Texture newWeaponTexture,float x,float y,int weaponNum){

        super(newWeapon,newWeaponTexture,"newWeapon");
        newWeapon.setPosition(x,y);
        if(weaponNum>4){
            this.wand = true;
            this.weaponDamage = 1;
            this.weaponFireRate = 1;
        }else  {
            this.wand =false;
            this.weaponDamage = 3;
            this.weaponFireRate = 0;
        }
        if(weaponNum==0||weaponNum==4){
            this.element=Element.WATER;
        }else if(weaponNum==1||weaponNum==5){
            this.element=Element.EARTH;
        }else if(weaponNum==2||weaponNum==6){
            this.element=Element.FIRE;
        }else{this.element=Element.WIND;}

        getAndSetTexture();
    }

    /*
    * This method sets the sprites texture depending on which weapon it is
     */
    private void getAndSetTexture() {
        Texture ww = new Texture();
        Texture ew = new Texture();
        Texture fw = new Texture();
        Texture aw = new Texture();
        Texture ws = new Texture();
        Texture es = new Texture();
        Texture fs = new Texture();
        Texture as = new Texture();
        try{
            ww.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\waterWand.png"));
            ew.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\earthWand.png"));
            fw.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\fireWand.png"));
            aw.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\windWand.png"));
            ws.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\waterStaff.png"));
            es.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\earthStaff.png"));
            fs.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\fireStaff.png"));
            as.loadFromFile(Paths.get("C:\\Users\\sony\\Documents\\210images\\windStaff.png"));
        }
        catch (Exception e){
            System.out.println(e);
        }

        if(wand==true){
            if(this.element==Element.WATER){
                sprite.setTexture(ww);
            }else if(this.element==Element.EARTH){
                sprite.setTexture(ew);
            }else if(this.element==Element.FIRE){
                sprite.setTexture(fw);
            }else{sprite.setTexture(aw);}
        }else{
            if(this.element==Element.WATER){
              sprite.setTexture(ws);
            }else if(this.element==Element.EARTH){
                sprite.setTexture(es);
            }else if(this.element==Element.FIRE){
                sprite.setTexture(fs);
            }else{sprite.setTexture(as);}
        }
    }
    
}
