import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public class Projectile extends Entity {
    private int velocity;
    private Vector2f direction;


    public Projectile(Sprite s, Texture t, String id, int v, Vector2f vector){
        super(s, t, id);
        v = velocity;
        direction = vector;
    }
    public void collision(){}
    public void fire(){
        sprite.move(10, 0);
    }
    public Vector2f getDirection() {
        return direction;
    }
}
