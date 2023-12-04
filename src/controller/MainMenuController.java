package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
    private GameController gameController;

    public MainMenuController(GameController gameController) {
        this.gameController = gameController;
    }

    public ActionListener getStartGameListener() {
        return new StartGameListener();
    }

    private class StartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleStartGame();
        }
    }

    private void handleStartGame() {
        String playerName = JOptionPane.showInputDialog("Please Enter a Name");
        if (playerName == null || playerName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid name. Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int initialBalance;
        try {
            initialBalance = Integer.parseInt(JOptionPane.showInputDialog("Please Enter Balance"));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid balance. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        gameController.startGame(playerName, initialBalance);
    }
}