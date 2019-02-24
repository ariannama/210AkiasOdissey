import org.jsfml.graphics.Texture;
import org.jsfml.graphics.IntRect;
import java.nio.file.Paths;

public class Wall extends sceneObject{
	public Wall(Texture t, float x, float y, int pos){
		super(t, "wall");
		Texture nt = new Texture();
		try{
			switch(pos){
				case 1:
					nt.loadFromFile(Paths.get("..\\images\\wall-topleft.png"));
					break;
				case 2:
					nt.loadFromFile(Paths.get("..\\images\\wall-topright.png"));
					break;
				case 3:
					nt.loadFromFile(Paths.get("..\\images\\wall-lefttop.png"));
					break;
				case 4:
					nt.loadFromFile(Paths.get("..\\images\\wall-leftbottom1.png"));
					break;
				case 5:
					nt.loadFromFile(Paths.get("..\\images\\wall-topleftedge.png"));
					break;
				case 6:
					nt.loadFromFile(Paths.get("..\\images\\wall-toprightedge.png"));
					break;
				case 7:
					nt.loadFromFile(Paths.get("..\\images\\wall-bottomleftedge.png"));
					break;
				case 8:
					nt.loadFromFile(Paths.get("..\\images\\wall-bottomrightedge.png"));
					break;
				
			}
        }
        catch (Exception e){
            System.out.println("Wall failed to load" + e);
        }
		this.sprite.setPosition(x, y);
        this.sprite.setTexture(nt);
		this.sprite.setTextureRect(new IntRect(0, 0, 79, 72));
		super.resize(this.sprite);
	}
}