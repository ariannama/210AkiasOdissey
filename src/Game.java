import org.jsfml.audio.Music;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Game {

    public RenderWindow window;
    public Menu menu;
    public Player player;

    int directionX = 0;
    int directionY = 0;

    public Game(){
        VideoMode vm = new VideoMode(1024, 630);
        RenderWindow window = new RenderWindow(vm, "Akia's Odyssey", WindowStyle.CLOSE);
        menu = new Menu();
        runMenu(window);
    }

    public void runMenu(RenderWindow window) {
        boolean menuOpen = true;
        Music bgMusic = new Music();
        Path p6 = Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\sounds\\adventurers.wav");
        try {
            bgMusic.openFromFile(p6);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bgMusic.setLoop(true);
        bgMusic.play();

        while (window.isOpen() == true) {
            Vector2i mousePos = Mouse.getPosition(window);
            Vector2f mousePosF = new Vector2f(mousePos);
            for (Event event : window.pollEvents()) {
                if (menuOpen == true) {
                    for (Sprite temp : menu.menuSprites) {
                        window.draw(temp);
                    }
                }
                if (event.type == Event.Type.CLOSED) {
                        window.close();
                }
                if((Mouse.isButtonPressed(Mouse.Button.LEFT) == true) && (menu.getSpriteGlobalBoundsNew().contains(mousePosF) || menu.getSpriteGlobalBoundContinue().contains(mousePosF))) {
                    printing();
                    menuOpen = false;
                }
                if(menuOpen == false){
                    window.clear();
                    //initGame();
                }
            }
            window.display();
        }
    }

    public void printing(){
        System.out.println("hey");
    }

    public void initGame(){
        //window.clear();
        boolean initGame = true;
        Texture playerT = new Texture();
        Texture bgT = new Texture();
        try{
            bgT.loadFromFile(Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\images\\BGbackground.jpg"));
            //playerT.loadFromFile(Paths.get("..\\images\\firepit.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        player = new Player(playerT,5, 1, 5, 5, 0, 0 );
        player.s.setPosition(100,100);
        while (initGame == true) {
            window.draw(player.getSprite());
        }
        runGame();
    }

    public void runGame(){
        Texture tt = new Texture();
        Button b = new Button(tt);
        while (window.isOpen()){
            player.calcMove();
            for(Event e : window.pollEvents()){
                player.move();
            }
            window.draw(player.getSprite());
            window.draw(b.getSprite());
            window.display();
            window.clear();
        }
    }
}
