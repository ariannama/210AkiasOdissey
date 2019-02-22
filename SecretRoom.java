public class SecretRoom extends room{
    private String[][] roomTile;
    public SecretRoom(int floor){
        super(floor);
        roomTile = super.getRoomTile();
        super.setWall();
    }
    public void spawnItem(){
        
    }
}
