
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import java.io.IOException;
import java.nio.file.Paths;

public class Test{
    public static void main (String[] args) {
        int screenWidth  = 1024;
        int screenHeight = 768;

        RenderWindow window = new RenderWindow(new VideoMode(screenWidth, screenHeight), "Akya's Oddysey");
        Texture imgTexture = new Texture();
        Texture back = new Texture();
        Texture leftWizard = new Texture();
        try {
            imgTexture.loadFromFile(Paths.get("H:\\wizard.png"));
            back.loadFromFile(Paths.get("H:\\background.jpg"));
            leftWizard.loadFromFile(Paths.get("H:\\leftWizard.png"));
            System.out.println("success");
        } catch (IOException ex) {
            ex.printStackTrace( );
        }
        imgTexture.setSmooth(true);
        Character img = new Character(imgTexture);
        double i = 0.07;

        img.setScale((float)i ,(float)i );

        double x = 0.5;
        Sprite background = new Sprite(back);
        background.setScale((float) x, (float) x);

        System.out.println(imgTexture.getSize());
        System.out.println(img);

        while (window.isOpen()) {
            for (Event e : window.pollEvents()) {
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.ESCAPE))
            {
                window.close();
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.UP))
            {
                img.move(0, -1);
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.DOWN))
            {
                img.move(0, 1);
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.LEFT))
            {
                img.move(-1, 0);
                img.setTexture(leftWizard);
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.RIGHT))
            {
                img.move(1, 0);
                img.setTexture(imgTexture);
            }
            if(Keyboard.isKeyPressed(Keyboard.Key.SPACE))
            {
            }


            window.clear();
            window.draw(background);
            window.draw(img);
            //figure.draw(window);
            window.display();
        }
    }
}
