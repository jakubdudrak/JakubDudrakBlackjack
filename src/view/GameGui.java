import model.Dealer;
import model.Deck;
import model.Player;
import view.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//https://www.tutorialspoint.com/swing/swing_event_handling.htm
public class GameGui{
/**
 *
 * This class creates the GUI JFrame for the main game
 *
 * **/
    private boolean gameOver;
    private boolean playerWon;
    private int enteredBal;

    public boolean isPlayerWon() {
        return playerWon;
    }

    public int getEnteredBal() {
        return enteredBal;
    }

    public void setEnteredBal(int enteredBal) {
        this.enteredBal = enteredBal;
    }

    public boolean playerWon() {
        return playerWon;
    }

    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void renderFrameGame(Player player, Dealer dealer, Deck deck){

        dealer.dealCards(player, deck);
        BackgroundPanel background = new BackgroundPanel(new ImageIcon(("Assets\\CardsImgs\\BlackJackBoard.png")).getImage(),player,dealer,deck);

        JFrame frameGame = new JFrame();
        JTextArea gameConsole = new JTextArea();

        JLabel playerScore = new JLabel(player.getName() + " Cards: " + player.getCardsValue());
        JLabel dealerScore = new JLabel(dealer.getName() + " Cards: " + dealer.getCardsValue());
        JLabel playerBal = new JLabel(player.getName() + " Balance: €" + player.getBalance());

        JButton continueButton = new JButton("Hit");
        JButton backButton = new JButton("Stand");
        JPanel controls = new JPanel();{
            controls.add(playerBal);
            playerScore.setBounds(550,800,200,30);

            controls.add(playerScore);
            playerScore.setBounds(550,820,200,30);

            controls.add(continueButton);
            continueButton.setBounds(550,850,100,40);

            controls.add(backButton);
            backButton.setBounds(650,850,100,40);

            controls.add(dealerScore);
            playerScore.setBounds(550,870,200,30);
        }

        frameGame.setTitle("Blackjack!");
        //https://www.tutorialspoint.com/how-to-display-a-jframe-to-the-center-of-a-screen-in-java#:~:text=A%20JFrame%20is%20like%20a%20Window%20with%20border%2C,using%20the%20setLocationRelativeTo%20%28%29%20method%20of%20Window%20class.
        //frameGame.setLocationRelativeTo(null);
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
                playerScore.setText("model.Player Cards: " + player.allCardVal());
                background.cards[3] = player.getCards().get(player.getCards().size()-1);
                background.paintComponent(background.getGraphics());
                if(player.isBust()){
                    //https://stackoverflow.com/questions/17979438/how-to-perform-action-on-ok-of-joptionpane-showmessagedialog
                    background.paintComponent(background.getGraphics());
                    JOptionPane.showMessageDialog(frameGame, "You went BUST! :(", "Game Over", JOptionPane.ERROR_MESSAGE);
                    int bal = (player.getBalance() - getEnteredBal());
                    player.setBalance(bal);
                    setGameOver(true);
                    setPlayerWon(false);
                    player.getCards().clear();
                    dealer.getCards().clear();
                    frameGame.dispose();
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dealer.underSeventeen(deck);
                for (int i = 0; i < 3; i++) {
                    background.dealerCards[i] = background.dealerCards[i+1];
                }
                background.paintComponent(background.getGraphics());
                if(dealer.isBust()){
                    JOptionPane.showMessageDialog(frameGame, "You WON! $$$", "Game Over", JOptionPane.PLAIN_MESSAGE);
                    setGameOver(true);
                    setPlayerWon(true);
                    int bal = (getEnteredBal() + player.getBalance());
                    player.setBalance(bal);
                    player.getCards().clear();
                    dealer.getCards().clear();
                    frameGame.dispose();
                }
                if(!dealer.isBust() && dealer.allCardVal() > player.allCardVal()){
                    JOptionPane.showMessageDialog(frameGame, "You WON! $$$", "Game Over", JOptionPane.PLAIN_MESSAGE);
                    setGameOver(true);
                    setPlayerWon(true);
                    int bal = (getEnteredBal() + player.getBalance());
                    player.setBalance(bal);
                    player.getCards().clear();
                    dealer.getCards().clear();
                    frameGame.dispose();
                }
                if(!dealer.isBust() && dealer.allCardVal() < player.allCardVal()){
                    JOptionPane.showMessageDialog(frameGame, "You LOST! :(", "Game Over", JOptionPane.ERROR_MESSAGE);
                    setGameOver(true);
                    setPlayerWon(false);
                    int bal = (player.getBalance() - getEnteredBal());
                    player.setBalance(bal);
                    player.getCards().clear();
                    dealer.getCards().clear();
                    frameGame.dispose();
                }
            }
        });

        frameGame.setVisible(true);
        setEnteredBal(Integer.parseInt(JOptionPane.showInputDialog("Please place a bet")));
    }
}
/*
*
*
*
* */
