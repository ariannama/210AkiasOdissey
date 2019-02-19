import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class Projectile extends Entity {
    private int velocity;

    public Projectile(Sprite s, Texture t, String id, int v){
        super(s, t, id);
        v = velocity;
    }
    public void collision(){}
    public void fire(){
        sprite.move(10, 0);
    }
}
