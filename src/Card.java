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

    public int convertVal(){
        switch (getValue()) {
            case "Ace":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "Jack":
            case "Queen":
            case "King":
                return 10;
        }
        return 0;
    }
    //Set an image for each card

    // To String
    @Override
    public String toString() {
        return  "Value: " + getValue()+
                "\nSuit: " + getSuit();
    }
}
