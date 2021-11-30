public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player("Jakub", 500);
        Dealer house = new Dealer();
        GameGui game = new GameGui();

        deck.shuffle();
        deck.shuffle();
        while (!game.isGameOver()) {
            game.renderFrameGame(player, deck, house);
        }
    }
}