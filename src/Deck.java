import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();

    //Deck Constructor
    public Deck(){
        populateDeck();
    }

    //User-Defined Methods

    private void populateDeck(){
        //The multi dimensional array was learned from https://www.youtube.com/watch?v=alwukGslBG8
        //The code was modified to fit a deck of cards and the for loop used to sort through the array was written by me

        String[][] cardAtt = new String[][]{{"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"},{"Diamonds","Hearts","Spades","Clubs"}};

        for (int i = 0; i < 4; i++){

            for (int j = 0; j < 13; j++) {
                cards.add(new Card(cardAtt[0][j], cardAtt[1][i]));
                }
            }
    }

    //To String
    @Override
    public String toString(){
        String output = "";
        for (int i = 0; i < 52; i++) {
            output += cards.get(i) + "\n\n";
        }

        //Collections.shuffle was found at https://roytuts.com/how-to-shuffle-an-arraylist-using-java/#:~:text=Shuffle%20means%20rearrange%20the%20elements%20of%20the%20ArrayList,on%20the%20maximum%20size%20of%20the%20existing%20ArrayList.
        String output1 = "";
        Collections.shuffle(cards);
        for (int i = 0; i < 52; i++) {
            output1 += cards.get(i) + "\n\n";
        }

        return "Cards: \n\n" + output + "\n\n" + cards.size() + "\n\n" + output1;
    }
}
