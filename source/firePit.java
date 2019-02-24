import org.jsfml.graphics.Texture;
import java.nio.file.Paths;

public class firePit extends sceneObject{
	public firePit(Texture t, float x, float y){
		super(t, "rock");
		
		Texture nt = new Texture();
		try{
			nt.loadFromFile(Paths.get("..\\images\\firepit.png"));
		}catch(Exception e){
			System.out.println("Firepit failed to load" + e);
		}
		this.sprite.setTexture(nt);
		super.resize(this.sprite);
		this.sprite.setPosition(x, y);
	}
}