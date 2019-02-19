import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Menu {
    ArrayList<Entity> menuEntity = new ArrayList<Entity>();
    public Background background;
    public Title title;
    public Button button1;
    public Button button2;

    public Menu(RenderWindow window){
        Texture backgroundT = new Texture();
        Texture titleT = new Texture();
        Texture button1T = new Texture();
        //Texture button2T = new Texture();
        try{
            backgroundT.loadFromFile(Paths.get("E:\\The Folder\\Game\\menu.png"));
            titleT.loadFromFile(Paths.get("E:\\The Folder\\Game\\title.png"));
            button1T.loadFromFile(Paths.get("E:\\The Folder\\Game\\Tee.png"));
            //button2T.loadFromFile(Paths.get("E:\\The Folder\\Game\\NButton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        background = new Background(backgroundT, window);
        title = new Title(titleT, window);
        button1 = new Button(button1T, window);
        //button2 = new Button(button2T, window);
        title.s.setPosition(148, 40);
        button1.s.setPosition(400, 400);
        button1.s.setScale(3,3);
        //button2.s.setPosition(363, 350);
        menuEntity.add(background);
        menuEntity.add(title);
        menuEntity.add(button1);
       //menuEntity.add(button2);

    }
}
