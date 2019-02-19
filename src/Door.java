/**
 * <h1>Door</h1>
 *
 * The door class describes the behaviour and attributes of the doors through which
 * the character accesses other rooms.
 *
 * @author: Arianna Marrocu
 */

public class Door {

    /**
     * doorState is an array of booleans which describes the current state of the door.
     * Its order is: open, closed, locked.
     */
    private boolean[] doorState = new boolean[3];
    /** doorPosition is an array of booleans which describes the current position of the door.
     * Its order is: north, west, south, east.
     */
    private boolean[] doorPosition = new boolean[4];
    //array of imgs for open doors
    //array of imgs for closed doors
    //array of imgs for locked doors

    public Door(String state, String position) {
        switch(state) {
            case "open":
                doorState[0] = true;
                doorState[1] = false;
                doorState[2] = false;
                break;
            case "closed":
                doorState[0] = false;
                doorState[1] = true;
                doorState[2] = false;
                break;
            case "locked":
                doorState[0] = false;
                doorState[1] = false;
                doorState[2] = true;
                break;
        }
        //switch for position

    }

    public void setDoorState(String state) {
        switch(state) {
            case "open":
                doorState[0] = true;
                doorState[1] = false;
                doorState[2] = false;
                break;
            case "closed":
                doorState[0] = false;
                doorState[1] = true;
                doorState[2] = false;
                break;
            case "locked":
                doorState[0] = false;
                doorState[1] = false;
                doorState[2] = true;
                break;
        }
    }

}
