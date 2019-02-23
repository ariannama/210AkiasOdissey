import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public class Projectile extends Entity {
    private Vector2f direction;


    public Projectile(Texture t, Vector2f vector){
        super(t);
        direction = vector;
    }
    public void collision(){}

    public void fire(){
        sprite.move(direction);
    }
    public Vector2f getDirection() {
        return direction;
    }
}