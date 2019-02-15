/**
 * <h1>Door</h1>
 *
 * The door class describes the behaviour and attributes of the doors through which
 * the character accesses other rooms.
 *
 * @author: Arianna Marrocu, Tom Barlow
 */

public class Door {

    /**
     * access is a boolean which describes whether the player can go through the door or not
     */
    private boolean access;
    /**
     * Class reference to room so it is able to read the number of enemies in the room.
      */
    room r;

    /**
     * Creates a door with an access based on the number of enemies in the room
     * If there are no enemies, the doors are open. If there are, the doors are closed.
     */
    public Door() {
       while (true){
          if(r.getEnemyCount() == 0) {
               access = true;
           }
          else {
               access = false;
           }
       }
    }
}
