import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GamePanel extends JPanel {

    public GamePanel(Player player, Dealer dealer){

    }

    @Override
    public void paintComponent(Graphics g){
        this.setLayout(new FlowLayout());
        super.paintComponent(g);
    }

    public void updateFrame(Player player) {
        for (int i = 0; i < player.getCards().size(); i++) {
            //getGraphics().drawImage((new ImageIcon("Assets\\CardsImgs\\" + player.getCards().get(i).getImg(player.getCards().get(i)))).getImage());
            getGraphics().drawImage((new ImageIcon(player.getCards().get(i).getImg())).getImage(), 0,0 , null);
        }
    }
}
