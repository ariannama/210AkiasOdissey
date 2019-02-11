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
        int screenWidth  = 1366;
        int screenHeight = 768;
        RenderWindow window = new RenderWindow(new VideoMode(screenWidth, screenHeight), "Akia's Oddysey", WindowStyle.CLOSE);
        Texture backGround = new Texture();
        try {
            //playerTexture.loadFromFile(Paths.get("E:\\The Folder\\Game\\front.png"));
            backGround.loadFromFile(Paths.get("E:\\The Folder\\Game\\BG.png"));
            System.out.println("--success--");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Sprite background = new Sprite(backGround);



        while (window.isOpen()) {
            for (Event e : window.pollEvents()) {
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.ESCAPE))
            {
                window.close();
            }
            window.clear();
            window.draw(background);
            //window.draw(img);
            window.display();
        }

    }
}