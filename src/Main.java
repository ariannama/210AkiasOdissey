import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.*;
import org.jsfml.window.event.Event;
import java.io.IOException;
import java.nio.file.Paths;

public class Main{
    public static void main (String[] args) {
        int screenWidth  = 1024;
        int screenHeight = 768;
        RenderWindow window = new RenderWindow(new VideoMode(screenWidth, screenHeight), "Akia's Oddysey", WindowStyle.CLOSE);

        Texture imgTexture = new Texture();
        Texture back = new Texture();
        Texture leftTexture = new Texture();
        Texture rightTexture = new Texture();
        Texture backTexture = new Texture();

        try {
            imgTexture.loadFromFile(Paths.get("C:\\Users\\mlynd\\Desktop\\210 Game\\front.png"));
            leftTexture.loadFromFile(Paths.get("C:\\Users\\mlynd\\Desktop\\210 Game\\left.png"));
            rightTexture.loadFromFile(Paths.get("C:\\Users\\mlynd\\Desktop\\210 Game\\right.png"));
            backTexture.loadFromFile(Paths.get("C:\\Users\\mlynd\\Desktop\\210 Game\\back.png"));
            back.loadFromFile(Paths.get("C:\\Users\\mlynd\\Desktop\\210 Game\\BG.png"));
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
        Player p = new Player(img, "Akia", 5, 1, 5, 5, 5,5);
        window.setFramerateLimit(200);
        while (window.isOpen()) {
            for (Event e : window.pollEvents()) {
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.ESCAPE))
            {
                window.close();
            }
            p.calcMove();
            p.move();
            window.clear();
            window.draw(background);
            window.draw(img);
            window.display();
        }
    }
}