import java.util.concurrent.ThreadLocalRandom;

public class Card {
    private String value;
    private String suit;

    //Card Constructor
    public Card(String value, String suit) {
        setValue(value);
        setSuit(suit);
    }

    //accessors and mutators
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    //Set an image for each card

    // To String
    @Override
    public String toString() {
        return  "Value: " + getValue()+
                "\nSuit: " + getSuit();
    }
}
