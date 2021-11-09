import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    private Card[] cards = new Card[52];

    //Deck Constructor
    public Deck(){
        populateDeck();
    }

    //User-Defined Methods

    private void populateDeck(){
        String[][] cardAtt = new String[][]{{"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"},{"Diamonds","Hearts","Spades","Clubs"}};

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < 13; j++) {
                for (int k = 0; k < 4; k++) {
                    cards[i] = new Card(cardAtt[0][j], cardAtt[1][k]);
                }
            }
        }
    }

    //To String
    @Override
    public String toString() {
        String output = "";
        int counter = 0;
        for (int i = 0; i < 52; i++) {
            ++counter;
            output += cards[i].toString() + "\n\n";

        }

        return "Cards: \n\n" + output + "\n\n" + counter;
    }
}
