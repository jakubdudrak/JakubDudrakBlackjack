import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Card {
    private String value;
    private String suit;

    //Card Constructor
    public Card() {
    generateValueSuit();
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

    //User-Defined Methods
    private void generateValueSuit(){
        String[][] cardAtt = new String[][]{{"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"},{"Diamonds","Hearts","Spades","Clubs"}};

        int random1 = ThreadLocalRandom.current().nextInt(0,12);
        int random2 = ThreadLocalRandom.current().nextInt(0,3);

         setValue(cardAtt[0][random1]);
         setSuit(cardAtt[1][random2]);

    }
    //Set an image for each card

    // To String
    @Override
    public String toString() {
        return  "Value: " + getValue()+
                "\nSuit: " + getSuit();
    }
}
