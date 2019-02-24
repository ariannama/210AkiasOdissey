import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

import java.nio.file.Paths;

/*
 * <h1>Passive</h1>
 *
 *  This is the Passive class
 *
 *  @Author Michael Heaver
 */
public class Passives extends Items{


    /*
    *   This is a list of all possible stat boosts depending on the passive
     */
    double bonusDamage, bonusMaxHealth, bonusFireRate,bonusMovementSpeed,bonusProjectileSpeed;
    int passiveNumber;

    /*
     *   This method returns the bonus damage
     */
    public double getBonusDamage(){
        return bonusDamage;
    }

    /*
     *   This method returns the bonus max health
     */
    public double getBonusMaxHealth(){
        return bonusMaxHealth;
    }

    /*
     *   This method returns the bonus firerate
     */
    public double getBonusFireRate(){
        return bonusFireRate;
    }

    /*
     *   This method returns the bonus movement speed
     */
    public double getBonusMovementSpeed(){
        return bonusMovementSpeed;
    }

    /*
     *   This method returns the bonus projectile speed
     */
    public double getBonusProjectileSpeed() {
        return bonusProjectileSpeed;
    }

    /*
    *  This method picks up the passive and leaves the pedestal
     */
	 @Override
    public void pickup(){
        Texture itemPedestal = new Texture();
        try{
            itemPedestal.loadFromFile(Paths.get("..\\itemPedestal.png"));
        }
        catch (Exception e){
            System.out.println(e);
        }
        setInactive();
    }

    /*
    * This method sets the bonus stats depending on what passive number it is
     */
    private void setStats() {
        this.bonusDamage=this.bonusFireRate=this.bonusMaxHealth=this.bonusMovementSpeed=this.bonusProjectileSpeed=0;
        if(passiveNumber==1) {
            this.bonusProjectileSpeed=0.25;
        }else if(passiveNumber==2){
            this.bonusMaxHealth = 1;
        }else if(passiveNumber==2){
            this.bonusFireRate = 0.25;
        }else if(passiveNumber==2){
            this.bonusMovementSpeed = 0.1;
        }else{this.bonusDamage = 1;}
    }

    /*
     * This is the constructor method for Passives
     * @param t is the blank texture which is overwritten with the correct texture
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     * @param passiveNum is the passive number that has different stats relative to its number
     */
    public Passives(Texture t,float x, float y,int passiveNum)
    {
        super(t,"passive");
		Texture nt = new Texture();
        this.passiveNumber = passiveNum;
        setStats();
        try{
            nt.loadFromFile(Paths.get("..\\images\\passivePedestal.png"));
        }
        catch (Exception e){
            System.out.println("Passive failed to load" + e);
        }
        this.sprite.setTexture(nt);
		super.resize(this.sprite);
		this.sprite.setPosition(x,y);
    }


}
