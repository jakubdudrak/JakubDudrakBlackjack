package controller;

import model.Dealer;
import model.Deck;
import model.GameObserver;
import model.Player;
import view.GameGui;
import view.MainMenuGui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameController implements GameObserver {

    private Player player;
    private Dealer dealer;
    private GameGui gameGui;
    private MainMenuGui mainMenuGui;
    private boolean gameOver;
    private boolean playerWon;
    private List<GameObserver> gameObservers = new ArrayList<>();
    public GameController() {
        Deck deck = Deck.getInstance();
        dealer = new Dealer();
    }

    public void setMainMenuGui(MainMenuGui mainMenuGui) {
        this.mainMenuGui = mainMenuGui;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isPlayerWon() {
        return playerWon;
    }


    public void startGame(String playerName, int initialBalance) {
        Deck deck = Deck.getInstance();
        player = new Player(playerName, initialBalance);
        deck.shuffle();
        dealer.dealCards(player, deck);
        gameGui = new GameGui(this);
        mainMenuGui.dispose();
        if (player.getBalance() <=0) {
            gameGui.onBankrupt();
        }
        //register observers
        addGameObserver(gameGui);
        gameGui.renderFrameGame(player, dealer, deck);
    }
    public GameGui getGameGui(){
        return this.gameGui;
    }
    private void gameLoop() {
        while (!gameOver) {
            if (dealer.isBust()) {
                handleGameOver(false);
            } else if (dealer.allCardVal() >= 17) {
                handleDealerTurn();
            }
            gameGui.updateGameDisplay(player, dealer);
        }
    }

    @Override
    public void onHit(Player player) {
        Deck deck = Deck.getInstance();
        dealer.hitCard(player, deck);
    }
    @Override
    public void onStand(Player player, Dealer dealer) {
        Deck deck = Deck.getInstance();
        handleDealerTurn();
        dealer.underSeventeen(deck);

        if ((dealer.isBust() && !player.isBust()) || (dealer.allCardVal() < player.allCardVal() && !player.isBust())) {
            handleGameOver(true);
        } else if (player.isBust()) {
            handleGameOver(false);
        } else {
            handleGameOver(false);
        }
    }

    private void handleDealerTurn() {
        Deck deck = Deck.getInstance();
        while (dealer.allCardVal() < 17) {
            dealer.hitCard(dealer, deck);
            gameGui.updateDealerCards(dealer);
            gameGui.updateDealerScore(dealer);
        }
    }

    public void handleGameOver(boolean playerWon) {
        //Notify Observers
        gameObservers.get(gameObservers.size()-1).onGameOver(playerWon);
        gameObservers.get(0).onGameOver(playerWon);
    }

    public void addGameObserver(GameObserver observer) {
        gameObservers.add(observer);
    }


    @Override
    public void onGameOver(boolean playerWon) {
        int bal = gameGui.getEnteredBal();
        if (!playerWon) {
            bal = -bal;
        }
        player.setBalance(player.getBalance() + bal);
        player.getCards().clear();
        dealer.getCards().clear();
        startGame(player.getName(), player.getBalance());
    }
}