public class Enemy extends Character
{
    final String name;
    int x;
    int y;
    int sight;
    int range;
    arena arena;

    public Enemy(String name, int x, int y, int sight, int range)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.sight = sight;
        this.range = range;
    }

    //if PLAYER within SIGHT move within RANGE to ATTACK, 
    //else WANDER(move to random adjacent tile)
    public void wander()
    {
        //pick a random adjacent tile and update x,y pos to match
    }

    public void updatePos()
    {
            //updates pos of enemys within the arean
    }

}
