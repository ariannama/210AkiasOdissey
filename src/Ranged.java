import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Ranged extends Enemy {

    protected ArrayList<Projectile> projectiles;
    protected long startTime;
    protected long fireRate;
    protected Texture projectileTexture = new Texture();

    public Ranged(Texture t, String ID, int dmg, int mS, int maxH){
        super(t, ID, dmg, mS, maxH);
        startTime = System.nanoTime() / 1000000;
        fireRate = 1000;
        try {
            projectileTexture.loadFromFile(Paths.get("../images/rock_projectile"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void attack(){
        long endTime = System.nanoTime() / 1000000;
        long totalTime = endTime - startTime;
        Vector2f playerPosition = player.getPlayerPos();
        if (totalTime > 1000) {
            startTime = System.nanoTime() / 1000000;
            Projectile spell = new Projectile(projectileTexture, playerPosition);
            spell.sprite.setPosition(this.sprite.getPosition());
            projectiles.add(spell);
        }
    }
}
