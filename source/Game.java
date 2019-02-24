import org.jsfml.audio.Music;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;
import org.jsfml.window.Mouse.Button;
import org.jsfml.graphics.IntRect;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.Math.*;

public class Game {

	//private ArrayList<room> r = new ArrayList<>();
    public RenderWindow window;
    public Menu menu;
	public Sprite bg;
	room r;
	Music bgMusic = new Music();
    int directionX = 0;
    int directionY = 0;
    boolean menuActive = true;
	Player player;

    public Game(){
        VideoMode vm = new VideoMode(1024, 630);
        window = new RenderWindow(vm, "Akia's Odyssey", WindowStyle.CLOSE);
        menu = new Menu(window);
		initGame();
		while(true){
			menu.runMenu();
			runGame();
		}
    }

    public void initGame(){
        Texture playerT = new Texture();
        Texture bgT = new Texture();
        try{
            bgT.loadFromFile(Paths.get("../images/backgroundtry.jpg"));
            playerT.loadFromFile(Paths.get("../images/playerWF.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
		
        player = new Player(playerT, 1, 1, 100, new Weapons(playerT, 0, 0, 4));
        player.sprite.setPosition(512,320);
        bg = new Sprite(bgT);
		bg.setPosition(79,70);
    }

    public void runGame(){
		Texture tt = new Texture();
		//Button b = new Button(tt);
		long startTime = 0;
		int newRoomID = 1;
			while (player.getAlive()){
				r = roomType(newRoomID);
				newRoomID = 0;
				r.playMusic();
				while(newRoomID == 0){
					window.draw(bg);
					r.drawRoom(window);
					window.draw(player.sprite);
					player.move();
					player.attack();
					player.moveProjectiles(window);
					outOfBound();
					if(r.doors.get(0).checkAccess(r)){
						newRoomID = collisionCheckDoor();
					}
					collisionCheck();
					for(Event e : window.pollEvents()){
						if(e.type == Event.Type.CLOSED){
							System.exit(0);
						}
					}
					window.display();
					window.clear();
					//window.draw(player.getSprite());
					//window.draw(b.getSprite());
				}
				r.stopMusic();
			}
	}
	public room roomType(int roomNum){
		room nR = null;
		switch(roomNum){
			case 1:
				nR =  new SpawnRoom(1, roomNum);
				break;
			case 8:
				nR = new ItemRoom(1, roomNum);
				break;
			case 9:
				nR = new ShopRoom(1, roomNum);
				break;
			case 10:
				nR = new preSecretRoom(1, roomNum);
				break;
			case 11:
				nR = new SecretRoom(1, roomNum);
				break;
			case 12:
				nR = new BossRoom(1, roomNum);
				break;
			default:
				nR = new StandardRoom(1, roomNum);
				break;
		}
		return nR;
	}
	public int collisionCheckDoor(){
		IntRect playerRect = new IntRect(player.sprite.getGlobalBounds());
		IntRect doorsRect;
		int newRoomID = 0;
		for(int i = 0;i<r.doors.size();i++){
			doorsRect = new IntRect(r.doors.get(i).sprite.getGlobalBounds());
			if(playerRect.intersection(doorsRect) != null){
				if(r.doors.get(i).pos==1||r.doors.get(i).pos==3){
					player.sprite.setPosition(playerRect.left,Math.abs(490-(playerRect.top + 71)));
				}
				if(r.doors.get(i).pos==2||r.doors.get(i).pos==4){
					//System.out.print(Math.abs(800-(playerRect.left)));
					player.sprite.setPosition(Math.abs(866-(playerRect.left + 80)),playerRect.top);
				}
				newRoomID = r.doors.get(i).doorNum;		
			}
		}
		return newRoomID;
	}
	
	public void outOfBound(){
		if(player.sprite.getPosition().y <= 65){
			player.sprite.setPosition(player.sprite.getPosition().x, 65);
		}
		if(player.sprite.getPosition().y >= 525){
			player.sprite.setPosition(player.sprite.getPosition().x, 525);
		}
		if(player.sprite.getPosition().x <= 75){
			player.sprite.setPosition(75, player.sprite.getPosition().y);
		}
		if(player.sprite.getPosition().x >= 945){
			player.sprite.setPosition(945, player.sprite.getPosition().y);
		}
	}
	 
public void collisionCheck(){
	IntRect playerRect;
	IntRect projectileRect;
	IntRect enemyRect;
	IntRect sceneobjectsRect;
	IntRect itemsRect;
	IntRect itemsChestRect;
	
	if(!(player.projectiles.isEmpty())){
		for(int i = 0;i< player.projectiles.size();i++){
			projectileRect = new IntRect(player.projectiles.get(i).sprite.getGlobalBounds());
			
			for(int j = 0;j< r.enemies.size();j++){
				enemyRect = new IntRect(r.enemies.get(j).sprite.getGlobalBounds());
				
				if(projectileRect.intersection(enemyRect)!= null){
					player.projectiles.remove(i);
					r.enemies.get(j).takeDamage();
					if(!r.enemies.get(j).getAlive()){
						r.enemies.remove(j);
					}
				}
				
			}
		}
	}
	
	playerRect = new IntRect(player.sprite.getGlobalBounds());
	
	for(int i = 0;i< r.so.size();i++){
		int offset = 0;
		sceneObject sceneObj = r.so.get(i);
		sceneobjectsRect = new IntRect(r.so.get(i).sprite.getGlobalBounds());
		if(playerRect.intersection(sceneobjectsRect)!= null){
			switch (player.getDirection()){
				case 'B':
					player.sprite.move(0 , player.moveSpeed);
					break;
				case 'F':
					player.sprite.move(0 , -player.moveSpeed);
					
					break;
				case 'L':
					player.sprite.move(player.moveSpeed, 0);
					
					break;
				case 'R':
					player.sprite.move(-player.moveSpeed, 0);
					
					break;
			}
		}
	}
		
	
	for(int i = 0;i < r.items.size();i++){
		itemsRect = new IntRect(r.items.get(i).sprite.getGlobalBounds());
		if(playerRect.intersection(itemsRect) != null){
			r.items.get(i).pickup();
			if(r.items.get(i) instanceof Chest){
				Chest c = (Chest)r.items.get(i);
				for(int j =0; j<(c.getChestItems()).size();j++){
					itemsRect = new IntRect(c.getItemSprite((Items)c.getChestItems().get(j)).getGlobalBounds());
					if(playerRect.intersection(itemsRect) != null){
						Items item = (Items)c.getChestItems().get(j);
						item.pickup();
						c.getChestItems().remove(j);
					}
				}						
			}
			
			if(r.items.get(i) instanceof Collectibles){
				r.items.remove(i);
			}
		}
		
	}
	
	for(int i = 0;i<r.enemies.size();i++){
		enemyRect = new IntRect(r.enemies.get(i).sprite.getGlobalBounds());
		if(r.enemies.get(i) instanceof Ranged){
			Ranged range = (Ranged)r.enemies.get(i); 
				for(int j =0; j<(range.projectiles.size());j++){
					projectileRect = new IntRect(range.projectiles.get(j).sprite.getGlobalBounds());
					if(projectileRect.intersection(playerRect) != null){
						player.takeDamage(range.damage);
					}
				}						
			}
		else if(enemyRect.intersection(playerRect)!= null){
				r.enemies.get(i).attack();
			}
		}
	}
	
}