import org.jsfml.graphics.Texture;
import java.nio.file.Paths;

/*
*   <h1>Torch<\h1>
*
*       This is the torch class
*       The player is required to "light both torches"
*       to access the secret room. They only spawn in the
*       pre-secret room
*
*       @Author Michael
 */
public class Torch extends Items {
    private boolean secretAccess;

    /*
        This method returns secret Access which if both torches secret access are true
        allows access to interact with the secret room door
     */
    public boolean getSecretAccess(){
        return secretAccess;
    }

    /*
        This is the pickup method which "lights" the torch
     */
    public void pickup(){
        if(!getInactive()){
            Texture litTorch = new Texture();
            try{
                litTorch.loadFromFile(Paths.get("..\\images\\litTorch.png"));
            }catch (Exception e){
                System.out.println("Lit failed to load" + e);
            }
            this.sprite.setTexture(litTorch);
            this.secretAccess = true;
            this.setInactive();
        }
    }

    /*
     * This is the constructor for the torch
     * @param t is a blank texture which is overwritten and replaced by an unlit torch
     * @param x is the x position
     * @param y is the y position
     */
    public Torch(Texture t, float x, float y){
        super(t,"Torch");
        this.sprite.setPosition(x,y);
        this.secretAccess = false;
        try{
            t.loadFromFile(Paths.get("..\\images\\unlitTorch.png"));
        }catch (Exception e){
            System.out.println("Unlit failed to load" + e);
        }
    }
}
