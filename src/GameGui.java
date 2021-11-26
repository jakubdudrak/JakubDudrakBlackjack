import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

//https://www.tutorialspoint.com/swing/swing_event_handling.htm
public class GameGui {

    public GameGui(){

    }

    public void renderFrameGame(Player player, Deck deck, Dealer dealer){
        BackgroundPanel background = new BackgroundPanel(new ImageIcon(("Assets\\CardsImgs\\BlackJackBoard.png")).getImage());
        JFrame frameGame = new JFrame();
        JTextArea gameConsole = new JTextArea();
        JButton continueButton = new JButton("Hit");
        JButton backButton = new JButton("Stand");

        frameGame.setTitle("Blackjack!");
        frameGame.setSize(1410,986);
        //https://www.javatpoint.com/BoxLayout
        frameGame.setLayout(new BorderLayout(0, 20));

        frameGame.add(background, BorderLayout.CENTER);
        frameGame.add(continueButton, BorderLayout.WEST);
        frameGame.add(backButton, BorderLayout.EAST);

        continueButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dealer.hitCard(player, deck);
                }
            });

        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setVisible(true);

    }
}
