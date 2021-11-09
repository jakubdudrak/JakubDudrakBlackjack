import java.util.Arrays;

public class Deck {
    private int deckSize;
    private Card[] cards = new Card[52];

    //Deck Constructor
    public Deck(int deckSize){
        setDeckSize(deckSize);
        populateDeck();
    }

    //mutators and accessors

    public int getDeckSize() {
        return deckSize;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    //populate deck array
    private boolean checkIfDrawn(Card card){
        for (int i = 0; i < 52; i++) {
            if(card == cards [i]){
                return true;
            }
        }
        return false;
    }

    private void populateDeck(){
        for (int i = 0; i < 52; i++) {
            Card newCard = new Card();
            while(checkIfDrawn(newCard)){
                cards[i] = newCard;
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
