package model;

import model.Card;
import model.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void allCardVal_shouldReturnCorrectValue() {
        Person person = new Person("Player1", 100);
        Card card1 = new Card("Ace", "Hearts");
        Card card2 = new Card("10", "Spades");
        person.giveCard(card1);
        person.giveCard(card2);
        assertEquals(21, person.allCardVal());
    }

    @Test
    void isBust_shouldReturnTrueIfBust() {
        Person person = new Person("Player1", 100);
        Card card1 = new Card("King", "Hearts");
        Card card2 = new Card("Queen", "Spades");
        Card card3 = new Card("Jack", "Diamonds");
        person.giveCard(card1);
        person.giveCard(card2);
        person.giveCard(card3);
        assertTrue(person.isBust());
    }
}
