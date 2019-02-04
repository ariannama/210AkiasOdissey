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
        Path p1 = Paths.get("H:\\icon.png");
        try {
            img.loadFromFile(p1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Texture bg = new Texture();
        Path p2 = Paths.get("H:\\bg.jpg");
        try {
            bg.loadFromFile(p2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sprite sp = new Sprite();
        sp.setTexture(bg);

        Vector2f r1 = new Vector2f(200, 100);
        RectangleShape b1 = new RectangleShape(r1);
        RectangleShape b2 = new RectangleShape(r1);
        b1.setPosition(550, 350);
        b2.setPosition(550, 450);
        b1.setFillColor(Color.YELLOW);
        b2.setFillColor(Color.YELLOW);
        b1.setOutlineThickness(5);
        b2.setOutlineThickness(5);
        b1.setOutlineColor(Color.BLACK);
        b2.setOutlineColor(Color.BLACK);
        w.setIcon(img);

        while(w.isOpen() == true){
            for(Event event :w.pollEvents()){
                if(event.type == Event.Type.CLOSED){
                    w.close();
                }
            }
            w.draw(sp);
            w.draw(b1);
            w.draw(b2);
            w.display();
        }



    }


}
