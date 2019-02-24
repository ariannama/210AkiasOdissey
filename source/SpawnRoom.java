//author: dian
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.jsfml.audio.Music;

public class SpawnRoom extends room{
    private String[][] roomTile;
	private Music bgMusic;
    public SpawnRoom(int floor, int currRoomNum){
        super(floor, currRoomNum);
		super.setWall();
		super.setDoor();
    }
	@Override
	public void playMusic(){
		bgMusic = new Music();
		Path musicPath = Paths.get("../sounds/W2TP.wav");
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
