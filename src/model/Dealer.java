package model;

public class Dealer extends Person {
    /**
     *
     * This is the model.Dealer object class. It inherits from model.Person
     *
     * **/
    public Dealer() {
        super("The House", 500000);
    }

    public void dealCards(Player player, Deck deck) {
        if (deck.size() < 2) {
            deck.shuffle();
        }

        // Deal two cards to the player
        player.giveCard(deck.getCardAt(0));
        player.giveCard(deck.getCardAt(1));

        // Deal two cards to the dealer
        this.giveCard(deck.getCardAt(0));
        this.giveCard(deck.getCardAt(1));
    }

    public void underSeventeen(Deck deck){
        while(allCardVal() < 17){
            giveCard(deck.getCardAt(0));
        }
    }

    public void hitCard(Person target, Deck deck){
        target.giveCard(deck.getCardAt(0));
    }
}