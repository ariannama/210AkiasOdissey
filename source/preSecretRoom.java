//author: dian
import java.util.Random;
import java.util.Random;
import java.util.ArrayList;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.audio.Music;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class preSecretRoom extends room{

	private Music bgMusic;
    private int enemyCount, rockCount, chestCount, coinCount, fireCount, keyCount, halfHeart, fullHeart, heartCount;
    private int maxEnemy = 2, maxChest = 1, maxCoin = 4, maxKey = 1, floor;
    private Random rand;
    private int holder, heart;
    private String[][] roomTile;
    private String path = "p ", chest = "ch", enemy = "e ", coin = "c ", fire = "f ", key = "k ", halfheart = "hh", fullheart = "fh", rock = "r ";
	private Torch torch1, torch2;
    public preSecretRoom(int floor, int currRoomNum){
        super(floor, currRoomNum);
        roomTile = super.getRoomTile();
        spawn();
        spawnTorch();
        super.setWall();
		super.setDoor();
    }
	@Override
	public void playMusic(){
		bgMusic = new Music();
		Path musicPath = Paths.get("../sounds/H2H.wav");
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
	
    public void spawn(){
		for(int y = 0; y < 7; y++){
			for(int x = 0; x < 11; x++){
				if(x != 5&& (y != 3 && y != 0)){
					rand = new Random();
					holder = rand.nextInt(1000) + 1;
					if(holder <= 700){
						roomTile[x][y] = path;
					}
					else if(holder > 700 && holder < 750){
						if(enemyCount < maxEnemy){
							roomTile[x][y] = enemy;
							//enemyCount++;
						}
						else
							roomTile[x][y] = "  ";
					}
					else if(holder >= 750 && holder < 850){
						roomTile[x][y] = rock;
						rockCount++;
						super.so.add(new Rock(super.blank, (x + 1) * super.tileX, (y + 1) * super.tileY));
					}
					else if(holder >= 850 && holder < 950){
						roomTile[x][y] = fire;
						fireCount++;
						super.so.add(new firePit(super.blank, (x + 1) * super.tileX, (y + 1) * super.tileY));
						
					}
					else if(holder >= 950 && holder <= 990){
						if(coinCount < maxCoin){
							roomTile[x][y] = coin;
							coinCount++;
							super.items.add(new Coin(super.blank, (x + 1)  * super.tileX, (y + 1) * super.tileY));
						}
						else
							roomTile[x][y] = path;
					}
					else if (holder >990 && holder < 998){
						if(heartCount < 1){
							Random heartRand = new Random();
							heart = heartRand.nextInt(100) + 1;
							if(heart <= 30){
								roomTile[x][y] = fullheart;
								fullHeart++;
								super.items.add(new FullHeart(super.blank, (x + 1)  * super.tileX, (y + 1) * super.tileY));
							}
							else{
								roomTile[x][y] = halfheart;
								halfHeart++;
								super.items.add(new HalfHeart(super.blank, (x + 1)  * super.tileX, (y + 1) * super.tileY));
							}
							heartCount++;
						}
						else
							roomTile[x][y] = path;
					}
					else if(holder == 998){
						if(keyCount < maxKey){
							roomTile[x][y] = key;
							keyCount++;
							super.items.add(new Keys(super.blank,  (x + 1)  * super.tileX, (y + 1) * super.tileY));
						}
						else
							roomTile[x][y] = path;
					}
					else{
						if(chestCount < maxChest){
							roomTile[x][y] = chest;
							chestCount++;
							if(holder == 999){
								super.items.add(new Chest(super.blank, (x + 1)  * super.tileX, (y + 1) * super.tileY,false));
								
							}
							else
								super.items.add(new Chest(super.blank, (x + 1)  * super.tileX, (y + 1) * super.tileY,true));
						}
						else
							roomTile[x][y] = path;
					}
				}
				else
					roomTile[x][y] = path;
			}
		}
    }

    
	public int getEnemyCount(){
        super.enemyCount = this.enemyCount;
		return this.enemyCount;
    }
    
    public void reduceEnemyCount(){
        this.enemyCount -= 1;
		super.enemyCount = this.enemyCount;
    }
    public void spawnTorch(){
        super.rtiw[4][0] = "t";
		torch1 = new Torch(super.blank, 4 * super.tileX, 0); 
		torch2 = new Torch(super.blank, 8 * super.tileX, 0); 
		super.items.add(torch1);
		super.items.add(torch2);
        super.rtiw[8][0] = "t";
    }
	
	public boolean checkTorch(){
		return (torch1.getSecretAccess() && torch2.getSecretAccess());
	}
}


    

