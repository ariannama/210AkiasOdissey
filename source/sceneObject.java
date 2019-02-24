import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.graphics.IntRect;

public class sceneObject extends Entity{
	protected String id;
	
	public void collision(){}
	
	protected sceneObject(Texture t, String id){
		super(t);
		this.id = id;
	}
	
	public Sprite getItemSprite(sceneObject i){
		return i.sprite;
	}
	
	protected void resize(Sprite s){
		this.sprite.setTextureRect(new IntRect(0, 0, s.getTexture().getSize().x, s.getTexture().getSize().y));
		Vector2f targetSize = new Vector2f(79.f, 70.f);
		s.setScale((targetSize.x / s.getTexture().getSize().x), (targetSize.y / s.getTexture().getSize().y));
	}
}