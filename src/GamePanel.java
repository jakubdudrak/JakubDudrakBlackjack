import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GamePanel extends JPanel {

    public GamePanel(Player player, Dealer dealer){
        Card[]  blanks = {new Card("Ace","Spades"), new Card("Ace","Spades"),new Card("Ace","Spades"),new Card("Ace","Spades")};
       // for (int i = 0; i < 4; i++) {
       //     getGraphics().drawImage(blanks[i].getImg(),0,0,null);
       // }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Card[]  blanks = {new Card("Ace","Spades"), new Card("Ace","Spades"),new Card("Ace","Spades"),new Card("Ace","Spades")};
        for (int i = 0; i < 4; i++) {
            Image img = blanks[i].getImg();
            g.drawImage(img,0,0,null);
        }
    }

    public void updateFrame(Player player) {
        for (int i = 0; i < player.getCards().size(); i++) {
            //getGraphics().drawImage((new ImageIcon("Assets\\CardsImgs\\" + player.getCards().get(i).getImg(player.getCards().get(i)))).getImage());
            getGraphics().drawImage(player.getCards().get(i).getImg(), 0,0 , null);
        }
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(1280, 386);
    }
}
