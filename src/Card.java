import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Card {
    private String value;
    private String suit;

    //Card Constructor
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

    public Image getImg(Card card){

        try {
            if(card.getSuit().equals("Hearts")) {
                switch (card.getValue()) {
                    case "Ace":
                    case "Ace One":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\AceHearts.png").getImage();
                    case "2":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\TwoHearts.png").getImage();
                    case "3":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\ThreeHearts.png").getImage();
                    case "4":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\FourHearts.png").getImage();
                    case "5":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\FiveHearts.png").getImage();
                    case "6":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\SixHearts.png").getImage();
                    case "7":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\SevenHearts.png").getImage();
                    case "8":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\EightHearts.png").getImage();
                    case "9":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\NineHearts.png").getImage();
                    case "10":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\TenHearts.png").getImage();
                    case "Jack":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\JackHearts.png").getImage();
                    case "Queen":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\QueenHearts.png").getImage();
                    case "King":
                        return new ImageIcon("JakubDudrakBlackjack\\Assets\\KingHearts.png").getImage();
                }
            }
        }
        //catch(FileNotFoundException fnfe){ fnfe.printStackTrace(); JOptionPane.showMessageDialog(null,"File could not be found!", "Problem Finding File!",JOptionPane.ERROR_MESSAGE); }
        //catch(IOException ioe){ ioe.printStackTrace(); JOptionPane.showMessageDialog(null,"File could not be read!", "Problem Writing to File!",JOptionPane.ERROR_MESSAGE); }
        //catch (ClassNotFoundException cnfe) { cnfe.printStackTrace();JOptionPane.showMessageDialog(null,"Could not convert object to the appropriate class!","Problem Converting Object Read From File!",JOptionPane.ERROR_MESSAGE); }
        catch (ClassCastException cce) { cce.printStackTrace(); JOptionPane.showMessageDialog(null,"Could not convert the object to the appropriate class!","Problem Converting Object!", JOptionPane.ERROR_MESSAGE); }
    return null;
    }

    // To String
    @Override
    public String toString() {
        return  "Value: " + getValue()+
                "\nSuit: " + getSuit();
    }
}
