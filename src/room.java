import java.util.Random;
import java.io.*;
import java.util.Arrays;

/*
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

    public room(int floor){
        super(floor);
        roomTile = new String[11][7];
        rtiw = new String[13][9];
        for(String[] s : roomTile){
            Arrays.fill(s, " ");
        }
    }

    public String[][] getRoomTile(){
        return roomTile;  
    }
    
    public void init(){
        
    }
    
    protected void setWall(){
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 13; x++){
                if(x == 0 || x == 12 || y == 0 || y == 8){
                    rtiw[x][y] = "w ";
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
    
    public void roomLeave(){
        try{
            File file = new File("C:\\Users\\dian\\Desktop\\room.csv");//Insert correct path
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
    
    /*public static void main(String[] args){
        room r = new room(1);
        r.readFile();
        r.printMap();
    }*/
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String[] row: rtiw){
            sb.append(Arrays.toString(row)).append("\r\n");
        }
        return sb.toString();
    }
}
