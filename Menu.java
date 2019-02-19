import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.function.*;

import org.jsfml.audio.SoundBuffer;
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

    /**
     * Constructor for the menu class - does not take any parameters
     */
    public Menu(){
        //Setting the size of the window and the title
        VideoMode vm = new VideoMode(1024, 630);
        RenderWindow w = new RenderWindow(vm, "Akia's Odyssey", WindowStyle.CLOSE);

        //Setting the icon of the game
        Image img = new Image();
        Path p1 = Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\images\\icon.png");
        try {
            img.loadFromFile(p1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        w.setIcon(img);

        //Setting the background and title
        Texture bg = new Texture();
        Texture logo = new Texture();
        Vector2f l1 = new Vector2f(728, 84);
        RectangleShape t1 = new RectangleShape(l1);
        t1.setPosition(148, 40);
        Path p2 = Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\images\\BGbackground.jpg");
        Path p3 = Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\images\\AKIAS-ODYSSEY (5).png");
        try {
            bg.loadFromFile(p2);
            logo.loadFromFile(p3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sprite backg = new Sprite();
        backg.setTexture(bg);
        t1.setTexture(logo);

        //Setting the buttons
        Vector2f r1 = new Vector2f(300, 125);
        RectangleShape b1 = new RectangleShape(r1);
        RectangleShape b2 = new RectangleShape(r1);
        b1.setPosition(362, 200);
        b2.setPosition(362, 350);
        Texture but1 = new Texture();
        Texture but2 = new Texture();
        Path p4 = Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\images\\continue-button.png");
        Path p5 = Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\images\\new-button.png");
        try {
            but1.loadFromFile(p4);
            but2.loadFromFile(p5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        b1.setTexture(but1);
        b2.setTexture(but2);

        //Making the buttons clickable
        Vector2i mousePos = Mouse.getPosition(w);
        Vector2f mousePosF = new Vector2f(mousePos);

        while(w.isOpen() == true){
            for(Event event :w.pollEvents()){
                if(event.type == Event.Type.CLOSED){
                    w.close();
                }
                if((Mouse.isButtonPressed(Mouse.Button.LEFT) == true) && (b1.getGlobalBounds().contains(mousePosF) || b2.getGlobalBounds().contains(mousePosF))){
                    System.out.println("hey");
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
