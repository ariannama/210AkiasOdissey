import java.util.Random;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.RenderWindow;
import java.nio.file.Paths;

/*
author: dian
boss b
item i
secret h
shop c
spawn o
standard s
preSecret p
*/
public class room extends Map{
    protected String[][] roomTile;
    protected String[][] rtiw;
	protected Texture blank = new Texture();
	protected final int tileX = 79, tileY = 70;
	protected int enemyCount = 0;
	ArrayList<Items> items = new ArrayList<>();
	ArrayList<sceneObject> so = new ArrayList<>();
	ArrayList<Door> doors = new ArrayList<>();
	ArrayList<Enemy> enemies = new ArrayList<>();
	
	static int currRoomNum = 1;

    public room(int floor, int currRoomNum){
        super(floor);
		this.currRoomNum = currRoomNum;
        roomTile = new String[11][7];
        rtiw = new String[13][9];
        for(String[] s : roomTile){
            Arrays.fill(s, " ");
        }
		try{
            blank.loadFromFile(Paths.get("..\\images\\blank.png"));
        }
        catch (Exception e){
            System.out.println("Thanos failed to load" + e);
        }
    }

	public void playMusic(){}
	public void stopMusic(){}
	
    public String[][] getRoomTile(){
        return roomTile;  
    }
    
    
    protected void setWall(){
		int pos = 0;
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 13; x++){
                if(x == 0 || x == 12 || y == 0 || y == 8){
                    rtiw[x][y] = "w ";
					if(x == 0){
						if (y <= 4){
							pos = 3;
						}
						else{
							pos = 4;
						}
					}else if (x == 12){
						if (y <= 4){
							pos = 4;
						}
						else{
							pos = 3;
						}
					}
					if(y == 0){
						if (x <= 6){
							if (x == 0){
								pos = 5;
							}
							else{
								pos = 1;
							}
						}else{
							if(x == 12){
								pos = 6;
							}else{
								pos = 2;
							}
						}
					}else if(y == 8){
						if (x <= 6){
							if (x == 0){
								pos = 7;
							}
							else{
								pos = 2;
							}
						}else{
							if (x == 12){
								pos = 8;
							}
							else{
								pos = 1;
							}
						}
					}
					so.add(new Wall(blank, x * tileX, y * tileY, pos));
                }
                else{
                    rtiw[x][y] = roomTile[x -1][y - 1];
                }
                //System.out.print(rtiw[x][y]);
            }
            //System.out.println();
        }
        //System.out.println();
    }
    protected void setDoor(){
		if(doorExist(1) != 0){
			doors.add(new Door(blank, 6 * tileX, 0 * tileY, 1, doorExist(1)));
		}
		if(doorExist(3) != 0){
			doors.add(new Door(blank, 6 * tileX, 8 * tileY, 3, doorExist(3)));
		}
		if(doorExist(2) != 0){
			doors.add(new Door(blank, 0 * tileX, 4 * tileY, 2, doorExist(2)));
		}
		if(doorExist(4) != 0){
			doors.add(new Door(blank, 12 * tileX, 4 * tileY, 4, doorExist(4)));
		}
	}
	
    public void roomLeave(){
        try{
            File file = new File("../rooms/room.csv");//Insert correct path
            BufferedWriter bw = null;
            if(!file.exists()){
                file.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(toCSV());
            bw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private String toCSV(){
        String data = "";
        for(int y = 1; y < 8; y++){
            for(int x = 1; x < 12; x++){
                if(rtiw[x][y] != "r " && rtiw[x][y] != "f "){
                    rtiw[x][y] = "p";
                }
            }
        }
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 13; x++){
                data += rtiw[x][y].trim() + ", ";
            }
            data += "\r\n";
        }
        return data;
    }

	public void drawRoom(RenderWindow rw){
		for(sceneObject o : so){
			Sprite s = o.getItemSprite(o);
			rw.draw(s);
		}
		for(Door d : doors){
			Sprite s = d.getItemSprite(d);
			rw.draw(s);
		}
		for(Items j : items){
			Sprite s = j.getItemSprite(j);
			rw.draw(s);
		}
	}
	
     public int getEnemyCount(){
        return enemyCount;
    }
    
    public void reduceEnemyCount(){
        enemyCount -= 1;
    }
	
	public RoomData getRoomNum(){
		super.readFile();
		return super.roomArray.get(currRoomNum);
	}
	
	public void setCurrRoomNum(int currRoomNum){
		this.currRoomNum = currRoomNum;
	}
	
	public int doorExist(int pos){
		int exists = 0;
		super.readFile();
		RoomData rData = super.roomArray.get(currRoomNum - 1);
		switch(pos){
			case 1:
				exists = (rData.getRoomNumUp());
				break;
			case 2:
				exists = (rData.getRoomNumLeft());
				break;
			case 3:
				exists = (rData.getRoomNumDown());
				break;
			case 4:
				exists = (rData.getRoomNumRight());
				break;
		}
		return exists;
	}
	
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String[] row: rtiw){
            sb.append(Arrays.toString(row)).append("\r\n");
        }
        return sb.toString();
    }
}
