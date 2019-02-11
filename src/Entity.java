import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public abstract class Entity {
    protected Sprite sprite;
    protected String id;

    public Entity(Sprite s, String id) {
        this.sprite = s;
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