package model;

import model.Card;
import model.Deck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void getInstance_shouldReturnSameInstance() {
        Deck deck1 = Deck.getInstance();
        Deck deck2 = Deck.getInstance();
        assertSame(deck1, deck2);
    }

    @Test
    void shuffle_shouldChangeOrder() {
        Deck deck = Deck.getInstance();
        Deck originalDeck = Deck.getInstance();
        Card card1Before = originalDeck.getCardAt(0);
        Card card2Before = originalDeck.getCardAt(1);
        Card card3Before = originalDeck.getCardAt(2);
        deck.shuffle();
        Card card1After = deck.getCardAt(0);
        Card card2After = deck.getCardAt(1);
        Card card3After = deck.getCardAt(2);
        assertNotEquals(card1Before, card1After);
        assertNotEquals(card2Before, card2After);
        assertNotEquals(card3Before, card3After);
    }

    @Test
    void getCardAt_shouldReturnValidCard() {
        Deck deck = Deck.getInstance();
        Card card = deck.getCardAt(0);
        assertNotNull(card);
    }
}
