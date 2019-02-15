import org.jsfml.graphics.Texture;
import org.jsfml.graphics.Sprite;

/*
 * <h1>Coin</h1>
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

    public Weapons(Sprite newWeapon, Texture newWeaponTexture,float x,float y,int damage, int fireRate){

        super(newWeapon,newWeaponTexture,"newWeapon");
        newWeapon.setPosition(x,y);
        this.weaponDamage = damage;
        this.weaponFireRate =fireRate;
    }


    /*public void dropCurrentWeapon(Weapons oldWeapon,float x,float y){

    }*/
}
