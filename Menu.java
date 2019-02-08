import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.function.*;

import org.jsfml.system.*;
import org.jsfml.window.*;
import org.jsfml.window.event.*;
import org.jsfml.graphics.*;

/**
 * <h1>Menu</h1>
 *
 * The menu class outlines the appearance and behaviour of the game menu - the first screen
 * the player is greeted with when opening the game.
 *
 * @author: Arianna Marrocu
 */
public class Menu {

    public Menu(){
        VideoMode vm = new VideoMode(1100, 700);
        RenderWindow w = new RenderWindow(vm, "Akia's Odyssey", WindowStyle.CLOSE);

        Image img = new Image();
        Path p1 = Paths.get("H:\\Akia-images\\icon.png");
        try {
            img.loadFromFile(p1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        w.setIcon(img);

        Texture bg = new Texture();
        Texture logo = new Texture();
        Vector2f l1 = new Vector2f(708, 79);
        RectangleShape t1 = new RectangleShape(l1);
        t1.setPosition(196, 40);
        Path p2 = Paths.get("H:\\Akia-images\\bg.jpg");
        Path p3 = Paths.get("h:\\Akia-images\\AKIAS-ODYSSEY (2).png");
        try {
            bg.loadFromFile(p2);
            logo.loadFromFile(p3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sprite backg = new Sprite();
        backg.setTexture(bg);
        t1.setTexture(logo);

        Vector2f r1 = new Vector2f(200, 100);
        RectangleShape b1 = new RectangleShape(r1);
        RectangleShape b2 = new RectangleShape(r1);
        b1.setPosition(450, 300);
        b2.setPosition(450, 399);
        Texture but1 = new Texture();
        Texture but2 = new Texture();
        Path p4 = Paths.get("H:\\Akia-images\\button_start.png");
        Path p5 = Paths.get("H:\\Akia-images\\button_continue.png");
        try {
            but1.loadFromFile(p4);
            but2.loadFromFile(p5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        b1.setTexture(but1);
        b2.setTexture(but2);

        while(w.isOpen() == true){
            for(Event event :w.pollEvents()){
                if(event.type == Event.Type.CLOSED){
                    w.close();
                }
            }
            w.draw(backg);
            w.draw(t1);
            w.draw(b1);
            w.draw(b2);
            w.display();
        }



    }


}
