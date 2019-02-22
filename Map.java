import java.io.*;
import java.util.ArrayList;

public class Map {
    private ArrayList<RoomData> roomArray = new ArrayList<>();
    private static int floorNum;
    private int[][] roomMap = new int[5][5];
    
    public Map(int floor){
        this.floorNum = floor;
    }

    public void readFile(){
        String testFile = "C:\\Users\\dian\\Desktop\\floor1.csv";//Used on my laptop
        String csvFile = "..\\floors\\floor" + String.valueOf(floorNum) + "\\floor" + String.valueOf(floorNum) + ".csv";//Use this 
        BufferedReader br = null;
        String line = "";
        String csvSplit = ",";
        
        try{
            br = new BufferedReader(new FileReader(testFile));//change testfile to csvFile
            int i = 0;
            while((line = br.readLine()) != null){
                Object[] data = line.split(csvSplit);
                for(int j = 0; j < data.length; j++){
                    data[j] = data[j].toString().trim();
                }
                
                RoomData map = new RoomData(
                        Integer.parseInt((String) data[0]), 
                        Integer.parseInt((String) data[1]), 
                        data[2].toString(), 
                        Integer.parseInt((String) data[3]), 
                        Integer.parseInt((String) data[4]), 
                        Integer.parseInt((String) data[5]), 
                        Integer.parseInt((String) data[6]),
                        Integer.parseInt((String) data[7]),
                        Integer.parseInt((String) data[8]));
                roomArray.add(map);
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void printMap(){
        int jkjk = 1;
        for(RoomData r : roomArray){
            //System.out.println(jkjk);
            //System.out.println(r.getRoomNum());
            //System.out.print("x: " + r.getX());
            //System.out.println("  y: " + r.getY());
            roomMap[r.getY() - 1][r.getX() - 1] = r.getRoomNum();
            jkjk++;
        }
        for(int[] i : roomMap){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for(int[] i: roomMap){
            for(int j: i){
                room r;
                switch(j){
                    case 0:
                        r = new BlankRoom(1);
                        break;
                    case 1:
                        r = new SpawnRoom(1);
                        break;
                    case 8:
                        r = new ItemRoom(1);
                        break;
                    case 9:
                        r = new ShopRoom(1);
                        break;
                    case 10:
                        r = new preSecretRoom(1);
                        break;
                    case 11:
                        r = new SecretRoom(1);
                        break;
                    case 12:
                        r = new BossRoom(1);
                        break;
                    default:
                        r = new StandardRoom(1);
                }
                System.out.print(r.toString());
            }
            System.out.println();
        }
    }
}
