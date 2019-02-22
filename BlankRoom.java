package pkg210project;

public class BlankRoom extends room{
    private String[][] roomTile;
    public BlankRoom(int floor){
        super(floor);
        roomTile = super.getRoomTile();
        super.setWall();
    }
}
