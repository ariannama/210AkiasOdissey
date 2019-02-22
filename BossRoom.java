public class BossRoom extends room{
    private String[][] roomTile;
    public BossRoom(int floor){
        super(floor);
        roomTile = super.getRoomTile();
        super.setWall();
    }
    public void spawnBoss(){
        
    }
}
