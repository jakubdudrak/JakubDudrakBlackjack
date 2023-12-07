package model;

import model.Card;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardFactoryTest {

    @Test
    void createCard_shouldCreateValidCard() {
        Card card = CardFactory.createCard("Ace", "Spades");
        assertNotNull(card);
        assertEquals("Ace", card.getValue());
        assertEquals("Spades", card.getSuit());
    }

    @Test
    void createCard_withInvalidValue_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CardFactory.createCard("InvalidValue", "Hearts");
        });
    }

    @Test
    void createCard_withInvalidSuit_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            CardFactory.createCard("Ace", "InvalidSuit");
        });
    }
}