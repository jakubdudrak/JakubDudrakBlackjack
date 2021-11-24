import javax.swing.*;
import java.awt.*;

//https://www.tutorialspoint.com/swing/swing_event_handling.htm
public class GameGui {
    private JFrame frameGame;
    private JButton continueButton;
    private JButton backButton;
    private JTextArea gameConsole;
    public GameGui(){

    }

    public void renderFrameGame(){
        frameGame = new JFrame();
        gameConsole = new JTextArea();
        continueButton = new JButton("Hit");
        backButton = new JButton("Stand");

        frameGame.setTitle("Blackjack!");
        frameGame.setSize(1280,960);
        //https://www.javatpoint.com/BoxLayout
        frameGame.setLayout(new BorderLayout(0, 20));

        frameGame.add(gameConsole, BorderLayout.CENTER);
        frameGame.add(continueButton, BorderLayout.WEST);
        frameGame.add(backButton, BorderLayout.EAST);

        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setVisible(true);

    }
}
