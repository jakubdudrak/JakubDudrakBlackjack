package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 *
 * This is the model.Card object class
 *
 * **/

public class Card {
    private String value;
    private String suit;

    //model.Card Constructor
    public Card(String value, String suit) {
        setValue(value);
        setSuit(suit);
    }

    //accessors and mutators
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int convertVal(){
        switch (getValue()) {
            case "Ace One":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
            case "Jack":
            case "Queen":
            case "King":
                return 10;
            case "Ace":
                return 11;
        }
        return 0;
    }

    public Image getImg() {
        //ImageIO.read and file loading bug was got from Ibrahim Khalid
        String suit = this.getSuit();
        String value = this.getValue();

        String path = "/assets/";
        try {
            switch (value) {
                case "Back":
                    path += "CardBack.png";
                    break;
                case "Ace":
                case "Ace One":
                    path += "Ace" + suit + ".png";
                    break;
                case "2":
                    path += "Two" + suit + ".png";
                    break;
                case "3":
                    path += "Three" + suit + ".png";
                    break;
                case "4":
                    path += "Four" + suit + ".png";
                    break;
                case "5":
                    path += "Five" + suit + ".png";
                    break;
                case "6":
                    path += "Six" + suit + ".png";
                    break;
                case "7":
                    path += "Seven" + suit + ".png";
                    break;
                case "8":
                    path += "Eight" + suit + ".png";
                    break;
                case "9":
                    path += "Nine" + suit + ".png";
                    break;
                case "10":
                    path += "Ten" + suit + ".png";
                    break;
                case "Jack":
                    path += "Jack" + suit + ".png";
                    break;
                case "Queen":
                    path += "Queen" + suit + ".png";
                    break;
                case "King":
                    path += "King" + suit + ".png";
                    break;
                default:
                    path+= "BackCard.png";
                    break;
            }

            return ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // To String
    @Override
    public String toString() {
        return  "Value: " + getValue()+
                "\nSuit: " + getSuit();
    }
}