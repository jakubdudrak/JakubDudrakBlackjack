import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.EventListener;

//https://www.tutorialspoint.com/swing/swing_event_handling.htm
public class GameGui {

    public GameGui(){

    }






    public void renderFrameGame(Player player, Deck deck, Dealer dealer){
        BackgroundPanel background = new BackgroundPanel(new ImageIcon(("Assets\\CardsImgs\\BlackJackBoard.png")).getImage(),player,dealer,deck);

        JFrame frameGame = new JFrame();
        JTextArea gameConsole = new JTextArea();

        frameGame.setTitle("Blackjack!");
        frameGame.setSize(1285,990);
        //https://www.javatpoint.com/BoxLayout
        frameGame.setLayout(new BorderLayout(0, 20));

        frameGame.add(background, BorderLayout.CENTER);

        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setVisible(true);

    }
}
