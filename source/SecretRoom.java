//author: dian
import org.jsfml.audio.Music;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.ArrayList;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class SecretRoom extends room{
    private String[][] roomTile;
	private Music bgMusic;
    
	public SecretRoom(int floor, int currRoomNum){
        super(floor, currRoomNum);
        roomTile = super.getRoomTile();
		super.setWall();
		super.setDoor();
    }
    public void spawnItem(){
        
    }
	@Override
	public void playMusic(){
		bgMusic = new Music();
		Path musicPath = Paths.get("../sounds/GS.wav");
		try {
				bgMusic.openFromFile(musicPath);
		} catch (IOException e) {
				e.printStackTrace();
		}
		bgMusic.setLoop(true);
		bgMusic.play();
	}
	public void stopMusic(){
		bgMusic.stop();
	}
}
