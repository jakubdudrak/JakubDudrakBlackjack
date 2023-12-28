public class Dealer extends Person{
    /**
     *
     * This is the Dealer object class. It inherits from Person
     *
     * **/
    public Dealer() {
        super("The House", 500000);
    }

    public void dealCards(Player player, Deck deck){
        for (int i = 0; i < 2; i++) {
            player.giveCard(deck.getCardAt(0));
            this.giveCard(deck.getCardAt(0));
        }
    }

    public void underSeventeen(Deck deck){
        while(allCardVal() < 17){
            giveCard(deck.getCardAt(0));
        }
    }

    public void hitCard(Player player,Deck deck){
        player.giveCard(deck.getCardAt(0));
    }
}
