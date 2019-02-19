import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;

public class Game {
    public RenderWindow window;
    public Menu menu;

    public Game(){
        initWindow("Akia's Oddysey", 1024, 768);
        menu = new Menu(window);
        runMenu();
    }

    public void initWindow(String title, int width, int height){
        window = new RenderWindow(new VideoMode(width,height), title, WindowStyle.CLOSE);
    }

    public void runMenu(){
        while (window.isOpen()){
            for(Event e : window.pollEvents()){
                Vector2i mousePos2i = Mouse.getPosition(window);
                Vector2f mousePos2f = new Vector2f(mousePos2i);
                //System.out.println(menu.button1.s.getGlobalBounds());
                System.out.println(mousePos2f);
                //System.out.println(Mouse.getPosition());
                if((Mouse.isButtonPressed(Mouse.Button.LEFT) == true))
                    System.out.println("Fuck yeah");
                window.display();
            }
            for(Entity temp: menu.menuEntity){
                window.draw(temp.getSprite());
            }
            window.display();
        }
    }
}
