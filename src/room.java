//author: dian
public class room {
    private String[][] roomTile;

    public room(){
        roomTile = new String[11][7];
    }
    /*
    public void printRoom(){
        for(int y = 0; y < 7; y++){
            for(int x = 0; x < 11; x++){
                System.out.print(roomTile[x][y]);
            }
            System.out.println();
        }
        System.out.println("Chest: " + chestCount);
        System.out.println("Coin: " + coinCount);
        System.out.println("Enemy: " + enemyCount);
        System.out.println("Rock: " + rockCount);
        System.out.println("Firepit: " + fireCount);
        System.out.println("Key: " + keyCount);
        System.out.println("Half heart: " + halfHeart);
        System.out.println("Full heart: " + fullHeart);
    }
    */
    public String[][] getRoomTile(){
        return roomTile;
        
    }
    
    public void init(){
        
    }
}
