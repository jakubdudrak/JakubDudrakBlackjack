import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
/**
 *
 * This is the Background panel class which generates the 2d graphics for the game
 *
 * **/
//https://tips4java.wordpress.com/2008/10/12/background-panel/ class was refactored to fit this project
public class BackgroundPanel extends JPanel{

        private Image background;
            Card[] cards = {new Card("Back", "Spades"),new Card("Back", "Spades"),
            new Card("Back", "Spades"),new Card("Back", "Spades")};

            Card[] dealerCards = {new Card("Back", "Spades"),new Card("Back", "Spades"),
                    new Card("Back", "Spades"),new Card("Back", "Spades")};


        public BackgroundPanel(Image background,Player player, Dealer dealer, Deck deck){
            this.background = background;


            //https://www.javatpoint.com/FlowLayout
            setLayout(null);

            cards[3] = player.getCards().get(player.getCards().size()-1);
            cards[2] = player.getCards().get(player.getCards().size()-2);

            dealerCards[3] = dealer.getCards().get(dealer.getCards().size()-1);
            dealerCards[2] = dealer.getCards().get(dealer.getCards().size()-2);
        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(background, 0, 0, null);
            g.drawImage(cards[0].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),100,550,null);
            g.drawImage(cards[1].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),400,550,null);
            g.drawImage(cards[2].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),700,550,null);
            g.drawImage(cards[3].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),1000,550,null);

            g.drawImage(dealerCards[0].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),100,40,null);
            g.drawImage(dealerCards[1].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),400,40,null);
            g.drawImage(dealerCards[2].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),700,40,null);
            g.drawImage(dealerCards[3].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),1000,40,null);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(background.getWidth(this), background.getHeight(this));
        }

}
