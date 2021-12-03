import java.util.ArrayList;
/**
 *
 * This is the person super class from which player and dealer inherit
 *
 * **/
public class Person {
    private String name;
    private int balance;
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Person(String name, int balance) {
        setName(name);
        setBalance(balance);
    }
    public int getCardsValue(){
        Card card;
        for (int i = 0; i < cards.size(); i++) {
            card = cards.get(i);
        }
        return 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void giveCard(Card card) {
        cards.add(card);
    }

    public int allCardVal(){
        int counter = 0;
        for (int i = 0; i < getCards().size(); i++) {
            counter += getCards().get(i).convertVal();
        }
        return counter;
    }

    public boolean isBust(){
            if(allCardVal()>21){
                for (int i = 0; i < getCards().size(); i++) {
                    if(getCards().get(i).getValue().equals("Ace")){
                        getCards().get(i).setValue("Ace One");
                        break;
                    }
                }
            }

        if(allCardVal() >21)
            return true;
        else
            return false;
    }
}
