import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GamePanel extends JPanel {
    private JPanel gamePanel;

    public GamePanel(Player player, Dealer dealer){

    }

    public void paintComponent(Graphics g){
        this.setLayout(new FlowLayout());
        super.paintComponent(g);
        g.drawImage(new ImageIcon(("Assets\\CardsImgs\\BlackJackBoard.png")).getImage(), 0, 0, null);
    }
}
