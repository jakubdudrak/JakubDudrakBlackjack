
package model;

public interface GameObserver {
    void onGameOver(boolean playerWon);
    void onHit(Player player);
    void onStand(Player player, Dealer dealer);
}