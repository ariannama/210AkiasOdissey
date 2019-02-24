import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
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
	double weaponFireRate;
    private boolean wand;
    private Element element;
	private Texture t;

    public void pickup(){
        this.sprite.setPosition(400000,400000);
    }

    /*
    * These are the four elements
     */
    private enum Element{
        WATER, EARTH, FIRE, WIND
    }

    /*
    * Returns a texture depending on the element
     */
    public Texture getProjectile(){
        Texture water = new Texture();
        Texture earth = new Texture();
        Texture fire = new Texture();
        Texture air = new Texture();
        try{
			
			if(Element.WATER == element) {
				water.loadFromFile(Paths.get("..//images//ice_projectile.png"));
				return water;
			}else if(Element.EARTH == element){
				earth.loadFromFile(Paths.get("..//images//rock_projectile.png"));
				return earth;
			}else if(Element.FIRE == element){
				fire.loadFromFile(Paths.get("..//images//projectile_fire.png"));
				return fire;
			}else{
				air.loadFromFile(Paths.get("..//images//wind_projectile.png"));
				return air;
			}
		}
        catch (Exception e){
            System.out.println("Projectile texture failed to load " + e);
        }
		return t;
    }

    /*
     * This is the constructor method for Weapons
     * @param t is the blank texture that will be changed depending on the weapon number
     * @param x is the float position on the x axis to spawn in the window
     * @param y is the float position on the y axis to spawn in the window
     * @param weaponNum is the weapon number that has different weapon relative to its number
     */
    public Weapons(Texture blank,float x,float y,int weaponNum){

		
        super(blank,"newWeapon");
		t = blank;
        if(weaponNum>= 4){
            this.wand = true;
            this.weaponDamage = 1;
            this.weaponFireRate = 0.1;
        }else  {
            this.wand =false;
            this.weaponDamage = 3;
            this.weaponFireRate = 0.5;
        }
        if(weaponNum==0||weaponNum==4){
            this.element=Element.WATER;
        }else if(weaponNum==1||weaponNum==5){
            this.element=Element.EARTH;
        }else if(weaponNum==2||weaponNum==6){
            this.element=Element.FIRE;
        }else{this.element=Element.WIND;}

        getAndSetTexture();
		this.sprite.setPosition(x,y);
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
			if(wand==true){
				if(this.element==Element.WATER){
					ww.loadFromFile(Paths.get("..\\images\\waterWandPedestal.png"));
					sprite.setTexture(ww);
				}else if(this.element==Element.EARTH){
					ew.loadFromFile(Paths.get("..\\images\\earthWandPedestal.png"));
					sprite.setTexture(ew);
				}else if(this.element==Element.FIRE){
					fw.loadFromFile(Paths.get("..\\images\\fireWandPedestal.png"));
					sprite.setTexture(fw);
				}else{
					aw.loadFromFile(Paths.get("..\\images\\windWandPedestal.png"));
					sprite.setTexture(aw);
					}
			}else{
				if(this.element==Element.WATER){
					ws.loadFromFile(Paths.get("..\\images\\waterStaffPedestal.png"));
					sprite.setTexture(ws);
				}else if(this.element==Element.EARTH){
					es.loadFromFile(Paths.get("..\\images\\earthStaffPedestal.png"));
					sprite.setTexture(es);
				}else if(this.element==Element.FIRE){
					fs.loadFromFile(Paths.get("..\\images\\fireStaffPedestal.png"));
					sprite.setTexture(fs);
				}else{
					as.loadFromFile(Paths.get("..\\images\\windStaffPedestal.png"));
					sprite.setTexture(as);
					}
			}
			super.resize(this.sprite);
			}
        catch (Exception e){
            System.out.println(e);
        }
    }
	
	public char getWand(){
		if(wand){
			return 'W';
		}
		else
			return 'S';
	}
}
