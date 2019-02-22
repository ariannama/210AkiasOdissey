public class ShopRoom extends room{
    private String[][] roomTile;
    public ShopRoom(int floor){
        super(floor);
        roomTile = super.getRoomTile();
        super.setWall();
    }
    public void spawnItem(){
        
    }
}
