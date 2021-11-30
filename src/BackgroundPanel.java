import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

//https://tips4java.wordpress.com/2008/10/12/background-panel/ class was refactored to fit this project
public class BackgroundPanel extends JPanel{

        private Image background;
            Card[] cards = {new Card("Ace", "Spades"),new Card("Ace", "Spades"),
            new Card("Ace", "Spades"),new Card("Ace", "Spades")};
            JButton continueButton = new JButton("Hit");
            JButton backButton = new JButton("Stand");

        public BackgroundPanel(Image background,Player player, Dealer dealer, Deck deck){
            this.background = background;
            //https://www.javatpoint.com/FlowLayout
            setLayout(new FlowLayout(FlowLayout.LEFT,400,850));

            this.add(continueButton);
            this.add(backButton);

            continueButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dealer.hitCard(player, deck);
                    cards[3] = player.getCards().get(player.getCards().size()-1);
                    paintComponent(getGraphics());
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(background, 0, 0, null);
            g.drawImage(cards[0].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),100,550,null);
            g.drawImage(cards[1].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),400,550,null);
            g.drawImage(cards[2].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),700,550,null);
            g.drawImage(cards[3].getImg().getScaledInstance(200,250, BufferedImage.SCALE_SMOOTH),1000,550,null);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(background.getWidth(this), background.getHeight(this));
        }

}
