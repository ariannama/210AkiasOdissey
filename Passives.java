import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

/*
 * <h1>Coin</h1>
 *
 *  This is the Passive class
 *
 *  @Author Michael Heaver
 */
public class Passives extends Items{
    /*
        CSV file with list of all passives?
        maybe some equip method and pickup from super
        some special items will use ids to access special passives if equipped
     */

    /*
    *
    *   This is a list of all possible stat boosts depending on the passive
    *
     */
    int bonusDamage, bonusMaxHealth, bonusFireRate,bonusMovementSpeed;


    public int getBonusDamage(){
        return bonusDamage;
    }

    public int getBonusMaxHealth(){
        return bonusMaxHealth;
    }
    public int getBonusFireRate(){
        return bonusFireRate;
    }

    public int getBonusMovementSpeed(){
        return bonusMovementSpeed;
    }

    public void pickup(){

    }

    public Passives(Sprite passive, Texture passiveSkin,float x, float y)
    {
        super(passive,passiveSkin,"passive");
        passive.setPosition(x,y);
    }
}
