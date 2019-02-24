/**
 * <h1>Door</h1>
 *
 * The door class describes the behaviour and attributes of the doors through which
 * the character accesses other rooms.
 *
 * @author: Arianna Marrocu, Tom Barlow
 */
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.IntRect;
import java.nio.file.Paths;

public class Door extends sceneObject{

    /**
    * access is a boolean which describes whether the player can go through the door or not
    */
    private boolean access;
    /**
    * Class reference to room so it is able to read the number of enemies in the room.
    */
    room r;
    int pos, doorNum;

    /**
    * Creates a door with an access based on the number of enemies in the room
    * If there are no enemies, the doors are open. If there are, the doors are closed.
    */
    public Door(Texture t, float x, float y, int pos, int doorNum) {
		super(t, "Door");
		this.pos = pos;
		this.doorNum = doorNum;
		
		Texture nt = new Texture();
		try{
			switch(pos){
				case 1: 
					nt.loadFromFile(Paths.get("..\\images\\closeDoor-up.png"));
					break;
				case 2:
					nt.loadFromFile(Paths.get("..\\images\\closeDoor-left.png"));
					break;
				case 3: 
					nt.loadFromFile(Paths.get("..\\images\\closeDoor-down.png"));
					break;
				case 4: 
					nt.loadFromFile(Paths.get("..\\images\\closeDoor-right.png"));
					break;
			}
			switch(doorNum){
				case 11:
					nt.loadFromFile(Paths.get("..\\images\\wall1.png"));
					break;
				case 12:
					nt.loadFromFile(Paths.get("..\\images\\doorclosed-bossroom.png"));
			}
        }catch (Exception e){
            System.out.println("Door failed to load" + e);
        }
		this.sprite.setTexture(nt);
		super.resize(this.sprite);
		this.sprite.setPosition(x, y);
    }
	
	public boolean checkAccess(room r){
		return(r.getEnemyCount() == 0);
	}
	
	public int getDoorPos(){
		return this.pos;
	}
}
