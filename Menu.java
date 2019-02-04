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
        Texture img = new Texture();
        Path p = Paths.get("H:\\bg.jpg");
        try {
            img.loadFromFile(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sprite sp = new Sprite();
        sp.setTexture(img);
        RectangleShape b1 = new RectangleShape();
        RectangleShape b2 = new RectangleShape();
        while(w.isOpen() == true){
            for(Event event :w.pollEvents()){
                if(event.type == Event.Type.CLOSED){
                    w.close();
                }
            }
            w.draw(sp);
            w.display();
        }



    }


}
