import org.jsfml.graphics.Texture;

public class Melee extends Enemy{

    protected Player player;
    protected long startTime;
    public Melee(Texture t, String ID, int dmg, int mS, int maxH){
        super(t, ID, dmg, mS, maxH);
        startTime = System.nanoTime() / 1000000;
    }

    public void attack() {
        long endTime = System.nanoTime() / 1000000;
        long totalTime = endTime - startTime;
        if (totalTime > 1000) {
            startTime = System.nanoTime();
            player.takeDamage(damage);
        }
    }
}