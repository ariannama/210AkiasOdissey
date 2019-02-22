public class SpawnRoom extends room{
    private String[][] roomTile;
    public SpawnRoom(int floor){
        super(floor);
        roomTile = super.getRoomTile();
        super.setWall();
    }
}
