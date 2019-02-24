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



public class ShopRoom extends room{
    private String[][] roomTile;
	private Music bgMusic;
    public ShopRoom(int floor, int currRoomNum){
        super(floor, currRoomNum);
        roomTile = super.getRoomTile();
		spawnItem();
		super.setWall();
		super.setDoor();
    }
	@Override
	public void playMusic(){
		bgMusic = new Music();
		Path musicPath = Paths.get("../sounds/YB.wav");
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
    public void spawnItem(){
		Random rand = new Random();
		super.items.add(new Weapons(super.blank, 4 * super.tileX, 4 * super.tileY, rand.nextInt(8) + 1));
		super.items.add(new FullHeart(super.blank, 6 * super.tileX, 4 * super.tileY));
		super.items.add(new Keys(super.blank,  8 * super.tileX, 4 * super.tileY));
		}
	/*
	@Override
	public void drawRoom(RenderWindow rw){
		for(Items j : i){
			Sprite s = j.getItemSprite(j);
			//System.out.println(s);
			rw.draw(s);
		}
	}*/
}
