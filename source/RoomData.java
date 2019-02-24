public class RoomData {
    int floorNum, roomNum, roomNumUp, roomNumRight, roomNumDown, roomNumLeft, x, y;
    String roomType;
    
    public RoomData(int floorNum, int roomNum, String roomType, int roomNumUp, int roomNumRight, int roomNumDown, int roomNumLeft, int x, int y){  
        this.floorNum = floorNum;
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.roomNumUp = roomNumUp;
        this.roomNumRight = roomNumRight;
        this.roomNumDown = roomNumDown;
        this.roomNumLeft = roomNumLeft;
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getRoomNum(){
        return roomNum;
    }
	public int getRoomNumUp(){
		return roomNumUp;
	}
	public int getRoomNumDown(){
		return roomNumDown;
	}
	public int getRoomNumLeft(){
		return roomNumLeft;
	}
	public int getRoomNumRight(){
		return roomNumRight;
	}
    @Override
    public String toString(){
        return String.format("floorNum: %d, roomNum: %d, roomType: %s, \r\n"
                + "roomNumUp: %d, roomNumRight: %d, roomNumDown: %d, roomNumLeft: %d\r\n"
                + "x: %d, y: %d", floorNum, roomNum, roomType, roomNumUp, roomNumRight, roomNumDown, roomNumLeft, x, y);
    }
}
