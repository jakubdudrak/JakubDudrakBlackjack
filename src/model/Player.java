
package model;

import java.io.*;
/**
 *
 * This is the player class. It stores data about the player
 *
 * **/
public class Player extends Person implements Serializable {
    private static int playerID;

    public Player(String name, int balance) {
        super(name, balance);
        incrementID();
    }

    private static void incrementID(){
        ++playerID;
    }

    @Override
    public String toString() {
        return
                "ID: " +
                        playerID;
    }
}
