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
 * The menu class represents the menu of the game.
 *
 * @author: Arianna Marrocu
 */
public class Menu {

    public Menu(){
        VideoMode vm = new VideoMode(500, 500);
        RenderWindow w = new RenderWindow(vm, "Akia's Odissey", WindowStyle.DEFAULT);
        w.create(vm, "Akia's Odissey");
        w.setVisible(true);
        w.display();
        while(w.isOpen()){
            for(Event event :w.pollEvents()){
                if(event.type == Event.Type.CLOSED){
                    w.close();
                }
            }
        }

    }


}
