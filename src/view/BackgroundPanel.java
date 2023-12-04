package view;

import model.Card;
import model.Dealer;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the Background panel class which generates the 2d graphics for the game.
 * https://tips4java.wordpress.com/2008/10/12/background-panel/ class was refactored to fit this project.
 */
public class BackgroundPanel extends JPanel {

    private Image background;
    private ArrayList<Card> cards;
    private ArrayList<Card> dealerCards;
    private static final int CARD_WIDTH = 200;
    private static final int CARD_HEIGHT = 250;
    private static final int CARD_OVERLAP = 200;

    public BackgroundPanel(Image background, Card[] initialPlayerCards, Card[] initialDealerCards) {
        this.background = background;
        this.cards = new ArrayList<>(Arrays.asList(initialPlayerCards));
        this.dealerCards = new ArrayList<>(Arrays.asList(initialDealerCards));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);

        for (int i = 0; i < cards.size(); i++) {
            renderCard(g, cards.get(i), 100 + i * CARD_OVERLAP, 550);
        }

        for (int i = 0; i < dealerCards.size(); i++) {
            renderCard(g, dealerCards.get(i), 100 + i * CARD_OVERLAP, 40);
        }
    }

    private void renderCard(Graphics g, Card card, int x, int y) {
        g.drawImage(card.getImg().getScaledInstance(CARD_WIDTH, CARD_HEIGHT, BufferedImage.SCALE_SMOOTH), x, y, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(background.getWidth(this), background.getHeight(this));
    }

    public void updatePlayerCards(Player player) {
        cards.clear();
        cards.addAll(player.getCards());
        repaint();
    }

    public void updateDealerCards(Dealer dealer) {
        dealerCards.clear();
        dealerCards.addAll(dealer.getCards());
        repaint();
    }

}