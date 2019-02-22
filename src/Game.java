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
    boolean menuActive = true;

    public Game(){
        VideoMode vm = new VideoMode(1024, 630);
        RenderWindow window = new RenderWindow(vm, "Akia's Odyssey", WindowStyle.CLOSE);
        menu = new Menu();
        runMenu(window);
    }

    public void runMenu(RenderWindow window) {
        boolean menuOpen = true;

        Music bgMusic = new Music();
        Path p6 = Paths.get("sounds\\adventurers.wav");
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
                if(menuOpen == true) {
                    if((Mouse.isButtonPressed(Mouse.Button.LEFT) == true) && (menu.getSpriteGlobalBoundsNew().contains(mousePosF) || menu.getSpriteGlobalBoundContinue().contains(mousePosF))) {
                        System.out.println("hey");
                        window.clear();
                        initGame(window);
                        menuOpen = false;
                    }
                }

                if (event.type == Event.Type.CLOSED) {
                        window.close();
                }
            }
            initGame(window);
            if (menuOpen == true) {
                for (Sprite temp : menu.menuSprites) {
                    window.draw(temp);
                }
            }
            window.display();
        }
    }

    public void initGame(RenderWindow window){
        Texture playerT = new Texture();
        Texture bgT = new Texture();
        try{
            bgT.loadFromFile(Paths.get("images\\bg.jpg"));
            playerT.loadFromFile(Paths.get("images\\player.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        player = new Player(playerT,5, 1, 5, 5, 0, 0 );
        player.s.setPosition(100,100);
        Sprite bg = new Sprite(bgT);
        window.draw(bg);
        window.draw(player.getSprite());
        window.display();

        //runGame();
    }

    public void runGame(RenderWindow window){
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
