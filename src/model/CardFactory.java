
package model;

import java.util.Arrays;

public class CardFactory {

    public static Card createCard(String value, String suit) {
        if (!isValidValue(value) || !isValidSuit(suit)) {
            throw new IllegalArgumentException("Invalid card value or suit");
        }
        return new Card(value, suit);
    }

    private static boolean isValidValue(String value) {
        String[] validValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        return Arrays.asList(validValues).contains(value);
    }

    private static boolean isValidSuit(String suit) {
        String[] validSuits = {"Diamonds", "Hearts", "Spades", "Clubs"};
        return Arrays.asList(validSuits).contains(suit);
    }
}