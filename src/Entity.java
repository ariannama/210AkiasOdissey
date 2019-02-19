import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public abstract class Entity {
    public Texture t;
    public Sprite s;
    public RenderWindow window;

    public Entity(Texture t, RenderWindow window){
        this.t = t;
        this.window = window;
        s = new Sprite(t);
    }

    public Sprite getSprite(){
        return s;
    }

    public Texture getTexture(){
        return t;
    }

    public void draw(){
        window.draw(s);
    }
}
