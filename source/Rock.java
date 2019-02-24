import org.jsfml.graphics.Texture;
import java.nio.file.Paths;

public class Rock extends sceneObject{
	public Rock(Texture t, float x, float y){
		super(t, "rock");
		
		Texture nt = new Texture();
		try{
			nt.loadFromFile(Paths.get("..\\images\\rock.png"));
		}catch(Exception e){
			System.out.println("Rock failed to load" + e);
		}
		this.sprite.setTexture(nt);
		super.resize(this.sprite);
		this.sprite.setPosition(x, y);
	}
}