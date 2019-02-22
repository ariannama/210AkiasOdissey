public class ItemRoom extends room{
    private String[][] roomTile;
    public ItemRoom(int floor){
        super(floor);
        roomTile = super.getRoomTile();
        super.setWall();
    }
    public void spawnItem(){
        
    }
}
