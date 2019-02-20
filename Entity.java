import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

/**
 * @author: Moses, Tom, Arianna, Olek
 */
public abstract class Entity {

    protected Sprite sprite;
    protected Texture texture;

    public Entity(Texture t) {
        this.texture = t;
        sprite = new Sprite(t);
    }

    public abstract void collision();


    public float getSpriteX() {
        return sprite.getPosition().x;

    }
    public float getSpriteY() {
        return sprite.getPosition().y;
    }

}
