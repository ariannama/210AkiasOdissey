import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.function.*;
import org.jsfml.audio.Music;

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
	
	private Sprite backg, backg2, story;
	private RectangleShape b1, b2, t1;
	private RenderWindow w;
	private float backgX, backgX2;
	private int x = 1024, y = 630;
    /**
     * Constructor for the menu class - does not take any parameters
     */
    public Menu(RenderWindow rw){
        //Setting the size of the window and the title
        w = rw;
		
        //Setting the icon of the game
//        Image img = new Image();
//        Path p1 = Paths.get("..//images//icon.png");
//        try {
//            img.loadFromFile(p1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        w.setIcon(img);

        //Setting initial storyboard
        Texture storyboard = new Texture();
        Path p6 = Paths.get("..\\images\\storyboard.png");
        try{
            storyboard.loadFromFile(p6);
        } catch (IOException e){
            e.printStackTrace();
        }
        story = new Sprite();
        story.setTexture(storyboard);
        //Setting the background and title
        Texture bg = new Texture();
		Texture bg2 = new Texture();
        Texture logo = new Texture();
        Vector2f l1 = new Vector2f(728, 84);
        t1 = new RectangleShape(l1);
        t1.setPosition(148, 40);
        Path p2 = Paths.get("\\images\\BG1.jpg");
        Path p3 = Paths.get("C:\\Users\\marrocu\\210AkiasOdissey\\images\\AKIAS-ODYSSEY.png");
        try {
            bg.loadFromFile(p2);
            bg2.loadFromFile(p2);
			
            logo.loadFromFile(p3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        backg = new Sprite();
        backg2 = new Sprite();
		bg.setSmooth(false);
		bg2.setSmooth(false);
        backg.setTexture(bg);
        backg2.setTexture(bg);
		backgX = backg.getPosition().x;
		backg2.setPosition(x + 1, 0);
		backgX2 = backg2.getPosition().x;
        
		
		t1.setTexture(logo);

        //Setting the buttons
        Vector2f r1 = new Vector2f(300, 125);
        b1 = new RectangleShape(r1);
        b2 = new RectangleShape(r1);
        b1.setPosition(362, 200);
        b2.setPosition(362, 350);
        Texture but1 = new Texture();
        Texture but2 = new Texture();
        Path p4 = Paths.get("\\images\\continue-button.png");
        Path p5 = Paths.get("C:\\Users\\marrocu\\210AkiasOdissey \\images\\new-button.png");
        try {
            but1.loadFromFile(p4);
            but2.loadFromFile(p5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        b1.setTexture(but1);
        b2.setTexture(but2);
		
        //Making the buttons clickable
	}
	
	public void runMenu(){
		boolean menuOpen = false;
		
		Music bgMusic = new Music();
        Path p7 = Paths.get("../sounds/HC.flac");
        try {
            bgMusic.openFromFile(p7);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bgMusic.setLoop(true);
        bgMusic.play();

        while(w.isOpen() == true && menuOpen == false) {
            w.draw(story);
        }
            for(Event event :w.pollEvents()){
                if(Keyboard.isKeyPressed(Keyboard.Key.SPACE)){
                    menuOpen = true;
                }
        }

        while(w.isOpen() == true && menuOpen == true){
			float windowbg1diff = backgX - w.getSize().x;
			if(backgX >= x){
				backgX = -(x - 10);
			}else{
				backgX += 0.1 * 3;
			}
			if(backgX2 >= w.getSize().x){
				backgX2 = -(x - 10);
			}else if (backgX2 < backgX){
				backgX2 = windowbg1diff + 5;
			}else{
				backgX2 += 0.1 * 3;
			}
			
			backg.setPosition(backgX, 0);
			backg2.setPosition(backgX2, 0);
			
			
			Vector2i mousePos = Mouse.getPosition(w);
			Vector2f mousePosF = new Vector2f(mousePos);
            for(Event event :w.pollEvents()){
                if(event.type == Event.Type.CLOSED){
                    w.close();
                }
				
                if(Mouse.isButtonPressed(Mouse.Button.LEFT) == true){
					if(b1.getGlobalBounds().contains(mousePosF) ){
						System.out.println("continue");
						w.clear();
						bgMusic.stop();
                        menuOpen = false;
					}
					else if(b2.getGlobalBounds().contains(mousePosF)){
						System.out.println("new game");
						w.clear();
						bgMusic.stop();
                        menuOpen = false;
					}
					else
						System.out.println("Clicked.");
				}
            }
            w.draw(backg);
            w.draw(backg2);
            w.draw(t1);
            w.draw(b1);
            w.draw(b2);
            w.display();
        }
	}
	
	public boolean getB1Bounds(){
		Vector2i mousePos = Mouse.getPosition(w);
        Vector2f mousePosF = new Vector2f(mousePos);
		return b1.getGlobalBounds().contains(mousePosF);
	}
	public boolean getB2Bounds(){
		Vector2i mousePos = Mouse.getPosition(w);
        Vector2f mousePosF = new Vector2f(mousePos);
		return b2.getGlobalBounds().contains(mousePosF);
	}


}
