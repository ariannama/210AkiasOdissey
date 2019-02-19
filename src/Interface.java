
import javafx.event.EventType;
import org.jsfml.graphics.*;
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

        RenderWindow window = new RenderWindow(new VideoMode(screenWidth, screenHeight), "Akia's Odyssey", WindowStyle.CLOSE);

        ArrayList<Projectile>  bullets = new ArrayList<>();
        ArrayList<Sprite>  walls = new ArrayList<>();
        Texture imgTexture = new Texture();
        Texture back = new Texture();
        Texture leftTexture = new Texture();
        Texture rightTexture = new Texture();
        Texture backTexture = new Texture();
        Texture bullet = new Texture();
        Texture coin = new Texture();
        Texture door = new Texture();
        Texture hitEnemy = new Texture();
        Texture wall = new Texture();
        try {
            imgTexture.loadFromFile(Paths.get("E:\\Character_spriteSheet FRONT.png"));
            leftTexture.loadFromFile(Paths.get("E:\\Character_spriteSheet LEFT.png"));
            rightTexture.loadFromFile(Paths.get("E:\\Character_spriteSheet RIGHT.png"));
            backTexture.loadFromFile(Paths.get("H:\\Character_spriteSheet BACK.png"));
            back.loadFromFile(Paths.get("E:\\playable.png"));
            bullet.loadFromFile(Paths.get("E:\\projectiles.png"));
            coin.loadFromFile(Paths.get("E:\\coin.png"));
            door.loadFromFile(Paths.get("E:\\door.png"));
            hitEnemy.loadFromFile(Paths.get("H:\\ENEMYcopy.png"));
            wall.loadFromFile(Paths.get("E:\\wall.png"));
            //coin.loadFromFile(Paths.get("C:\\Users\\dzialak\\IdeaProjects\\210AkiasOdissey\\images\\coin.png"));

            System.out.println("--success--");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int q = 0;
        int y = 0;
        for(int p = 0; p < 13; p++) {
            walls.add(new Sprite(wall));
            //walls.get(p).setScale(1, (float) 0.9);
            walls.get(p).setPosition(q,0);
            q+=85;
        }

        Coin c = new Coin(new Sprite(coin), coin, 80, 80);
        int directionX = 0;
        int directionY = 0;

        System.out.println(back.getSize());
        imgTexture.setSmooth(true);
        Sprite img = new Sprite(imgTexture);
        double i = 0.8;

        Sprite d = new Sprite(door);
        img.setScale((float)i ,(float)i );
        //img.setOrigin(img.getPosition().x+30,img.getPosition().y+40);
        img.setPosition(screenWidth/2, 100);

        boolean isShooting = false;

        Sprite background = new Sprite(back);
        System.out.println("SCALE: " + background.getScale());
        background.setPosition(50, 68);
        //background.setScale((float) 0.75, 1);

        Sprite enemy = new Sprite (imgTexture);
        enemy.setPosition(screenWidth/2, 300);
        System.out.println(imgTexture.getSize());
        System.out.println(img);

        Player p = new Player(img, imgTexture, "Akia", 5, 1, 5, 5, 0,0, window);
        Ranged r = new Ranged(enemy, imgTexture, "Akia", 5, 1, 5, 100);


        window.setFramerateLimit(60);
        long startTime = 0;
        long endTime = 0;
        long totalTime = 0;

        d.setPosition((screenWidth/2)-30, 0);
        d.setScale(1, (float)0.7);
        while (window.isOpen()) {
            for (Event e : window.pollEvents()) {

                p.calcMove();
                if(Keyboard.isKeyPressed(Keyboard.Key.RIGHT))
                {
                    isShooting = true;
                    directionX = 10;
                    directionY = 0;

                }
                if(Keyboard.isKeyPressed(Keyboard.Key.LEFT))
                {
                    isShooting = true;
                    directionX = -10;
                    directionY = -0;

                }
                if(Keyboard.isKeyPressed(Keyboard.Key.UP))
                {
                    isShooting = true;
                    directionY = -10;
                    directionX = 0;
                }
                if(Keyboard.isKeyPressed(Keyboard.Key.DOWN))
                {
                    isShooting = true;
                    directionY = 10;
                    directionX = 0;
                }

            }
            if (totalTime > 400 && isShooting) {
                startTime = System.nanoTime() / 1000000;
                Projectile projectile = new Projectile(new Sprite(bullet), bullet, "1", 2, new Vector2f(directionX, directionY));
                projectile.sprite.setScale((float) 0.4, (float) 0.4);
                projectile.sprite.setPosition(p.sprite.getPosition());
                bullets.add(projectile);
                isShooting = false;
            }

            window.clear();

            for (int j = 0; j < walls.size(); j++) {
                window.draw(walls.get(j));
            }
            window.draw(background);

            for (int a = 0; a < bullets.size(); a++) {
                window.draw(bullets.get(a).sprite);
                bullets.get(a).sprite.move(bullets.get(a).getDirection());
                if(bullets.get(a).getSpriteX()>950 || bullets.get(a).getSpriteX()<40 || bullets.get(a).getSpriteY()<60 || bullets.get(a).getSpriteY()>670)
                    bullets.remove(a);
            }

            if (Keyboard.isKeyPressed(Keyboard.Key.ESCAPE)) {
                window.close();
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.W))
            {
                p.sprite.move(0, -5);
                p.sprite.setTexture(backTexture);
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.S))
            {
                p.sprite.move(0, 5);
                p.sprite.setTexture(imgTexture);
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.A))
            {
                p.sprite.move(-5, 0);
                p.sprite.setTexture(leftTexture);
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.D))
            {
                p.sprite.move(5, 0);
                p.sprite.setTexture(rightTexture);
            }
            for (int j = 0; j < bullets.size() ; j++) {
                IntRect floatRect= new IntRect(bullets.get(j).sprite.getGlobalBounds());
                IntRect floatRect2= new IntRect(r.sprite.getGlobalBounds());
                if(floatRect.intersection(floatRect2) != null && r.getCurrentHealth() > 0) {
                    bullets.remove(j);
                    r.setCurrentHealth();
                    r.sprite.setTexture(hitEnemy);
                    if(r.getCurrentHealth() == 0){
                        r.sprite.setPosition(4000,4000);
                        //room.reduceEnemyCount();
                    }
                }
            }
            /*
            for (int b = 0; b< items.size(); b++)
            {
                if(player collides items[b])
                    items[b].pickup;
            }
            */
            IntRect floatRect= new IntRect(p.sprite.getGlobalBounds());
            IntRect floatRect2= new IntRect(c.sprite.getGlobalBounds());
            if (floatRect.intersection(floatRect2) != null) {
                c.pickUp();
                p.addCoin();
            }



            endTime = System.nanoTime() / 1000000;
            totalTime = endTime - startTime;

            window.draw(d);
            window.draw(p.sprite);
            window.draw(r.sprite);
            window.draw(c.sprite);
            r.sprite.setTexture(imgTexture);
            p.calcMove();
            window.display();

        }
    }

}
