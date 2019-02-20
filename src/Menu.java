import org.jsfml.audio.Music;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Menu {
    ArrayList<Sprite> menuSprites = new ArrayList<>();
    private Music bgMusic;
    private Button newButton;
    private Button continueButton;

    public Menu() {
        Texture backgroundT = new Texture();
        Texture titleT = new Texture();
        Texture button1T = new Texture();
        Texture button2T = new Texture();
        try {
            backgroundT.loadFromFile(Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\images\\BGbackground.jpg"));
            titleT.loadFromFile(Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\images\\AKIAS-ODYSSEY.png"));
            button1T.loadFromFile(Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\images\\new-button.png"));
            button2T.loadFromFile(Paths.get("H:\\210AkiasOdissey\\210AkiasOdissey\\images\\continue-button.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sprite title = new Sprite(titleT);
        Sprite background = new Sprite(backgroundT);
        newButton = new Button(button1T);
        continueButton = new Button(button2T);
        Sprite newB = newButton.getSprite();
        Sprite continueB = continueButton.getSprite();
        title.setPosition(148, 40);
        newB.setPosition(362, 200);
        continueB.setPosition(362, 350);
        menuSprites.add(background);
        menuSprites.add(title);
        menuSprites.add(newB);
        menuSprites.add(continueB);

    }
        public FloatRect getSpriteGlobalBoundsNew(){
                return newButton.getSpriteGlobalBounds();
        }

        public FloatRect getSpriteGlobalBoundContinue(){
            return continueButton.getSpriteGlobalBounds();
        }
}
