package view;

import model.Dealer;
import model.Deck;
import model.GameObserver;
import model.Player;
import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GameGui implements GameObserver {

    private GameController gameController;
    private JFrame frameGame;
    private BackgroundPanel background;
    private JLabel playerScore;
    private JLabel dealerScore;
    private JLabel playerBal;
    private JButton continueButton;
    private JButton backButton;
    private int enteredBal;
    private List<GameObserver> gameObservers = new ArrayList<>();

    public GameGui(GameController gameController) {
        this.gameController = gameController;
    }

    public boolean isPlayerWon() {
        return gameController.isPlayerWon();
    }

    public int getEnteredBal() {
        return enteredBal;
    }

    public void setEnteredBal(int enteredBal) {
        this.enteredBal = enteredBal;
    }

    public boolean isGameOver() {
        return gameController.isGameOver();
    }

    public void renderFrameGame(Player player, Dealer dealer, Deck deck) {

        background = new BackgroundPanel(
                new ImageIcon(getClass().getResource("/assets/BlackJackBoard.png")).getImage(),
                player.getCards().toArray(new model.Card[0]),
                dealer.getCards().toArray(new model.Card[0])
        );

        frameGame = new JFrame();
        playerScore = new JLabel(player.getName() + " Cards: " + player.getCardsValue());
        dealerScore = new JLabel(dealer.getName() + " Cards: " + dealer.getCardsValue());
        playerBal = new JLabel(player.getName() + " Balance: €" + player.getBalance());

        continueButton = new JButton("Hit");
        backButton = new JButton("Stand");

        JPanel controls = new JPanel();
        controls.add(playerBal);
        controls.add(playerScore);
        controls.add(continueButton);
        controls.add(backButton);
        controls.add(dealerScore);

        frameGame.setTitle("Blackjack!");
        frameGame.setSize(1285, 1050);
        frameGame.setLayout(new BorderLayout(0, 20));
        frameGame.add(background, BorderLayout.CENTER);
        frameGame.add(controls, BorderLayout.SOUTH);
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        updatePlayerScore(player);
        updateDealerScore(dealer);
        addGameObserver(gameController);
        addGameObserver(this);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (GameObserver observer : gameObservers) {
                    observer.onHit(player);
                }
                updateGameDisplay(player, dealer);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (GameObserver observer : gameObservers) {
                    observer.onStand(player, dealer);
                }
                updateGameDisplay(player, dealer);
            }
        });

        frameGame.setVisible(true);
        setEnteredBal(Integer.parseInt(JOptionPane.showInputDialog("Please place a bet")));
    }

    public void updateGameDisplay(Player player, Dealer dealer) {
        playerScore.setText(player.getName() + " Cards: " + player.allCardVal());
        updatePlayerCards(player);
        updateDealerCards(dealer);

        if (gameController.isGameOver()) {
            gameController.handleGameOver(gameController.isPlayerWon());
        }
    }
    public void addGameObserver(GameObserver observer) {
        gameObservers.add(observer);
    }
    @Override
    public void onGameOver(boolean playerWon) {
        SwingUtilities.invokeLater(() -> {
            if (playerWon) {
                JOptionPane.showMessageDialog(frameGame, "You WON! $$$", "Game Over", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frameGame, "You LOST! :(", "Game Over", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    @Override
    public void onStand(Player player, Dealer dealer){
        updatePlayerCards(player);
        updatePlayerScore(player);
        updateDealerCards(dealer);
        updateDealerScore(dealer);
    }
    @Override
    public void onHit(Player player) {
        updatePlayerCards(player);
        updatePlayerScore(player);
    }

    public void onBankrupt(){
        JOptionPane.showMessageDialog(frameGame, "You have been kicked out of the casino for going bankrupt :O!", "Bye Bye", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
    public void updatePlayerScore(Player player) {
        playerScore.setText(player.getName() + " Cards: " + player.allCardVal());
    }

    public void updateDealerScore(Dealer dealer) {
        dealerScore.setText(dealer.getName() + " Cards: " + dealer.allCardVal());
    }

    public void updatePlayerCards(Player player) {
        background.updatePlayerCards(player);
    }

    public void updateDealerCards(Dealer dealer) {
        background.updateDealerCards(dealer);
    }
}