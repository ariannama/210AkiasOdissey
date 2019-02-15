import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

/**
 * @author: Moses, Tom, Arianna, Olek
 */
public abstract class Entity {

    protected Sprite sprite;
    protected Texture texture;

    private String id;

    public Entity(Sprite s, Texture t, String id) {
        this.sprite = s;
        this.texture = t;
        this.id = id;
    }

    public abstract void collision();

    public String getId() {
        return id;
    }

    public float getSpriteX() {
        return sprite.getPosition().x;

    }
    public float getSpriteY() {
        return sprite.getPosition().y;
    }

}

