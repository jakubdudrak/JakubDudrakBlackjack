import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.EventListener;

//https://www.tutorialspoint.com/swing/swing_event_handling.htm
public class GameGui {
    private boolean gameOver = false;

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void renderFrameGame(Player player, Deck deck, Dealer dealer){
        BackgroundPanel background = new BackgroundPanel(new ImageIcon(("Assets\\CardsImgs\\BlackJackBoard.png")).getImage(),player,dealer,deck);

        JFrame frameGame = new JFrame();
        JTextArea gameConsole = new JTextArea();
        JLabel playerScore = new JLabel("Player Cards: " + player.getCardsValue());
        JButton continueButton = new JButton("Hit");
        JButton backButton = new JButton("Stand");
        JPanel controls = new JPanel();{
            controls.add(playerScore);
            playerScore.setBounds(550,820,200,30);

            controls.add(continueButton);
            continueButton.setBounds(550,850,100,40);

            controls.add(backButton);
            backButton.setBounds(650,850,100,40);
        }

        frameGame.setTitle("Blackjack!");
        frameGame.setSize(1285,1050);
        //https://www.javatpoint.com/BoxLayout
        frameGame.setLayout(new BorderLayout(0, 20));

        frameGame.add(background, BorderLayout.CENTER);
        frameGame.add(controls, BorderLayout.SOUTH);

        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    background.cards[i] = background.cards[i+1];
                }
                dealer.hitCard(player, deck);
                playerScore.setText("Player Cards: " + player.allCardVal());
                background.cards[3] = player.getCards().get(player.getCards().size()-1);

                if(player.isBust()){
                    JOptionPane.showMessageDialog(frameGame, "You went BUST! :(", "Game Over", JOptionPane.ERROR_MESSAGE);
                    setGameOver(true);
                }

                background.paintComponent(background.getGraphics());
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dealer.allCardVal()<17){
                    dealer.underSeventeen(deck);
                    for (int i = 0; i < 3; i++) {
                        background.dealerCards[i] = background.dealerCards[i+1];
                        background.dealerCards[3] = dealer.getCards().get(dealer.getCards().size()-1);
                    }

                }
                if(dealer.isBust()){
                    JOptionPane.showMessageDialog(frameGame, "You WON! $$$", "Game Over",JOptionPane.PLAIN_MESSAGE);
                    setGameOver(true);
                }
                background.paintComponent(background.getGraphics());
            }
        });

        frameGame.setVisible(true);
    }
}
