package model;

import controller.GameController;
import controller.MainMenuController;
import view.MainMenuGui;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameController gameController = new GameController();
        MainMenuController mainMenuController = new MainMenuController(gameController);

        MainMenuGui mainMenuGui = new MainMenuGui(mainMenuController.getStartGameListener());

        gameController.setMainMenuGui(mainMenuGui);
        gameController.addGameObserver(gameController);

        mainMenuGui.setVisible(true);
    }
}