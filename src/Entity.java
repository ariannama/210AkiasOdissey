import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public abstract class Entity {
    public Texture t;
    public Sprite s;
    public RenderWindow window;

    public Entity(Texture t){
        this.t = t;
        s = new Sprite(t);
    }

    public Sprite getSprite(){
        return s;
    }

    public Texture getTexture(){
        return t;
    }

    public abstract void collision();

    public float getSpriteX() {
        return s.getPosition().x;

    }
    public float getSpriteY() {
        return s.getPosition().y;
    }

    public FloatRect getSpriteGlobalBounds(){
        return s.getGlobalBounds();
    }
}
