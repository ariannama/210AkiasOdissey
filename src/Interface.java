
import javafx.event.EventType;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.*;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Vector;

public class Interface{
    public static void main (String[] args) {
        int screenWidth  = 1024;
        int screenHeight = 768;

        RenderWindow window = new RenderWindow(new VideoMode(screenWidth, screenHeight), "Akia's Oddysey", WindowStyle.CLOSE);

        ArrayList<Projectile>  bullets = new ArrayList<Projectile>();
        Texture imgTexture = new Texture();
        Texture back = new Texture();
        Texture leftTexture = new Texture();
        Texture rightTexture = new Texture();
        Texture backTexture = new Texture();
        Texture bullet = new Texture();
        try {
            imgTexture.loadFromFile(Paths.get("D:\\Character_spriteSheet FRONT.png"));
            leftTexture.loadFromFile(Paths.get("D:\\Character_spriteSheet LEFT.png"));
            rightTexture.loadFromFile(Paths.get("D:\\Character_spriteSheet RIGHT.png"));
            backTexture.loadFromFile(Paths.get("D:\\Character_spriteSheet BACK.png"));
            back.loadFromFile(Paths.get("D:\\issabackground.png"));
            bullet.loadFromFile(Paths.get("D:\\projectiles.png"));
            System.out.println("--success--");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Sprite b = new Sprite(bullet);



        System.out.println(back.getSize());
        imgTexture.setSmooth(true);
        Sprite img = new Sprite(imgTexture);
        double i = 0.8;

        img.setScale((float)i ,(float)i );
        img.setPosition(screenWidth/2, 0);




        Sprite background = new Sprite(back);
        System.out.println("SCALE: " + background.getScale());
        background.setScale((float) 0.75, 1);

        Sprite enemy = new Sprite (backTexture);
        enemy.setPosition(screenWidth/2, 600);
        System.out.println(imgTexture.getSize());
        System.out.println(img);

        Player p = new Player(img, imgTexture, "Akia", 5, 1, 5, 5, 5,5, window);
        Ranged r = new Ranged(enemy, imgTexture, "Akia", 5, 1, 5, 5);

        window.setFramerateLimit(60);
        long startTime = 0;
        long endTime = 0;
        long totalTime = 0;

        while (window.isOpen()) {
            for (Event e : window.pollEvents()) {
                p.calcMove();
                if(Keyboard.isKeyPressed(Keyboard.Key.RIGHT))
                {
                    if (totalTime > 400) {
                        startTime = System.nanoTime() / 1000000;
                        Projectile projectile = new Projectile(new Sprite(bullet), bullet, "1", 2);
                        projectile.sprite.setScale((float) 0.5, (float) 0.5);
                        projectile.sprite.setPosition(p.sprite.getPosition());
                        bullets.add(projectile);
                    }
                }
            }

            window.clear();
            window.draw(background);

            for (int a = 0; a < bullets.size(); a++) {
                window.draw(bullets.get(a).sprite);
                bullets.get(a).sprite.move(15, 0);
                if(bullets.get(a).getSpriteX()>950){
                    bullets.remove(a);
                }

            }
            if (Keyboard.isKeyPressed(Keyboard.Key.ESCAPE)) {
                window.close();
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.W))
            {
                p.sprite.move(0, -5);
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.S))
            {
                p.sprite.move(0, 5);
                //sprite.setTexture(texture);
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.A))
            {
                p.sprite.move(-5, 0);
                // sprite.setTexture(texture);
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.D))
            {
                p.sprite.move(5, 0);

            }
            endTime = System.nanoTime()/1000000;
            totalTime = endTime - startTime ;
            System.out.println(totalTime);
            window.draw(p.sprite);
            window.draw(r.sprite);
            p.calcMove();
            window.display();

        }
    }

}
