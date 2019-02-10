
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.*;
import org.jsfml.window.event.Event;

import java.io.IOException;
import java.nio.file.Paths;

public class Interface{
    public static void main (String[] args) {
        int screenWidth  = 1024;
        int screenHeight = 768;

        RenderWindow window = new RenderWindow(new VideoMode(screenWidth, screenHeight), "Akya's Oddysey", WindowStyle.CLOSE);
        Texture imgTexture = new Texture();
        Texture back = new Texture();
        Texture leftTexture = new Texture();
        Texture rightTexture = new Texture();
        Texture backTexture = new Texture();
        try {
            imgTexture.loadFromFile(Paths.get("H:\\Character_spriteSheet FRONT.png"));
            leftTexture.loadFromFile(Paths.get("H:\\Character_spriteSheet LEFT.png"));
            rightTexture.loadFromFile(Paths.get("H:\\Character_spriteSheet RIGHT.png"));
            backTexture.loadFromFile(Paths.get("H:\\Character_spriteSheet BACK.png"));
            back.loadFromFile(Paths.get("H:\\issabackground.png"));
            System.out.println("--success--");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(back.getSize());
        imgTexture.setSmooth(true);
        Sprite img = new Sprite(imgTexture);
        double i = 0.8;

        img.setScale((float)i ,(float)i );
        img.setPosition(screenWidth/2, 0);



        Sprite background = new Sprite(back);
        System.out.println("SCALE: " + background.getScale());
        background.setScale((float) 0.75, 1);

        System.out.println(imgTexture.getSize());
        System.out.println(img);
        Player p = new Player(img, imgTexture, "Akia", 5, 1, 5, 5, 5,5);

        while (window.isOpen()) {
            for (Event e : window.pollEvents()) {
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.ESCAPE))
            {
                window.close();
            }
            p.move();
            window.clear();
            window.draw(background);
            window.draw(img);
            window.display();
        }
    }
}
