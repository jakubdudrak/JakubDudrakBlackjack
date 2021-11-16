import java.util.ArrayList;

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

    public void giveCard(Card card) {
        cards.add(card);
    }
}
