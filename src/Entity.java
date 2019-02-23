import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public abstract class Entity {
    public Texture t;
    public Sprite sprite;

    public Entity(Texture t){
        this.t = t;
        sprite = new Sprite(t);
    }

    public Sprite getSprite(){
        return sprite;
    }

    public Texture getTexture(){
        return t;
    }

    public abstract void collision();

    public float getSpriteX() {
        return sprite.getPosition().x;

    }
    public float getSpriteY() {
        return sprite.getPosition().y;
    }

    public FloatRect getSpriteGlobalBounds(){
        return sprite.getGlobalBounds();
    }
}
