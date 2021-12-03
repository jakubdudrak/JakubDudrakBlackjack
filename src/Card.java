import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * This is the Card object class
 *
 * **/

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

    public Image getImg(){
        //ImageIO.read and file loading bug was got from Ibrahim Khalid

        try {
            if(this.getSuit().equals("Hearts")) {

                switch (this.getValue()) {
                    case "Ace":
                    case "Ace One":
                        return ImageIO.read(new File("Assets\\CardsImgs\\AceHearts.png"));
                    case "2":
                        return ImageIO.read(new File("Assets\\CardsImgs\\TwoHearts.png"));
                    case "3":
                        return ImageIO.read(new File("Assets\\CardsImgs\\ThreeHearts.png"));
                    case "4":
                        return ImageIO.read(new File("Assets\\CardsImgs\\FourHearts.png"));
                    case "5":
                        return ImageIO.read(new File("Assets\\CardsImgs\\FiveHearts.png"));
                    case "6":
                        return ImageIO.read(new File("Assets\\CardsImgs\\SixHearts.png"));
                    case "7":
                        return ImageIO.read(new File("Assets\\CardsImgs\\SevenHearts.png"));
                    case "8":
                        return ImageIO.read(new File("Assets\\CardsImgs\\EightHearts.png"));
                    case "9":
                        return ImageIO.read(new File("Assets\\CardsImgs\\NineHearts.png"));
                    case "10":
                        return ImageIO.read(new File("Assets\\CardsImgs\\TenHearts.png"));
                    case "Jack":
                        return ImageIO.read(new File("Assets\\CardsImgs\\JackHearts.png"));
                    case "Queen":
                        return ImageIO.read(new File("Assets\\CardsImgs\\QueenHearts.png"));
                    case "King":
                        return ImageIO.read(new File("Assets\\CardsImgs\\KingHearts.png"));
                }
            }
            if(this.getSuit().equals("Diamonds")) {
                switch (this.getValue()) {
                    case "Ace":
                    case "Ace One":
                        return ImageIO.read(new File("Assets\\CardsImgs\\AceDiamonds.png"));
                    case "2":
                        return ImageIO.read(new File("Assets\\CardsImgs\\TwoDiamonds.png"));
                    case "3":
                        return ImageIO.read(new File("Assets\\CardsImgs\\ThreeDiamonds.png"));
                    case "4":
                        return ImageIO.read(new File("Assets\\CardsImgs\\FourDiamonds.png"));
                    case "5":
                        return ImageIO.read(new File("Assets\\CardsImgs\\FiveDiamonds.png"));
                    case "6":
                        return ImageIO.read(new File("Assets\\CardsImgs\\SixDiamonds.png"));
                    case "7":
                        return ImageIO.read(new File("Assets\\CardsImgs\\SevenDiamonds.png"));
                    case "8":
                        return ImageIO.read(new File("Assets\\CardsImgs\\EightDiamonds.png"));
                    case "9":
                        return ImageIO.read(new File("Assets\\CardsImgs\\NineDiamonds.png"));
                    case "10":
                        return ImageIO.read(new File("Assets\\CardsImgs\\TenDiamonds.png"));
                    case "Jack":
                        return ImageIO.read(new File("Assets\\CardsImgs\\JackDiamonds.png"));
                    case "Queen":
                        return ImageIO.read(new File("Assets\\CardsImgs\\QueenDiamonds.png"));
                    case "King":
                        return ImageIO.read(new File("Assets\\CardsImgs\\KingDiamonds.png"));
                }
            }
            if(this.getSuit().equals("Spades")) {
                switch (this.getValue()) {
                    case "Back":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\CardBack.png")));
                    case "Ace":
                    case "Ace One":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\AceSpades.png")));
                    case "2":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\TwoSpades.png")));
                    case "3":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\ThreeSpades.png")));
                    case "4":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\FourSpades.png")));
                    case "5":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\FiveSpades.png")));
                    case "6":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\SixSpades.png")));
                    case "7":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\SevenSpades.png")));
                    case "8":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\EightSpades.png")));
                    case "9":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\NineSpades.png")));
                    case "10":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\TenSpades.png")));
                    case "Jack":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\JackSpades.png")));
                    case "Queen":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\QueenSpades.png")));
                    case "King":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\KingSpades.png")));
                }
            }
            if(this.getSuit().equals("Clubs")) {
                switch (this.getValue()) {
                    case "Ace":
                    case "Ace One":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\AceClubs.png")));
                    case "2":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\TwoClubs.png")));
                    case "3":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\ThreeClubs.png")));
                    case "4":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\FourClubs.png")));
                    case "5":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\FiveClubs.png")));
                    case "6":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\SixClubs.png")));
                    case "7":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\SevenClubs.png")));
                    case "8":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\EightClubs.png")));
                    case "9":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\NineClubs.png")));
                    case "10":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\TenClubs.png")));
                    case "Jack":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\JackClubs.png")));
                    case "Queen":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\QueenClubs.png")));
                    case "King":
                        return ImageIO.read(new File(("Assets\\CardsImgs\\KingClubs.png")));
                }
            }
        }
        //catch(FileNotFoundException fnfe){ fnfe.printStackTrace(); JOptionPane.showMessageDialog(null,"File could not be found!", "Problem Finding File!",JOptionPane.ERROR_MESSAGE); }
        //catch(IOException ioe){ ioe.printStackTrace(); JOptionPane.showMessageDialog(null,"File could not be read!", "Problem Writing to File!",JOptionPane.ERROR_MESSAGE); }
        //catch (ClassNotFoundException cnfe) { cnfe.printStackTrace();JOptionPane.showMessageDialog(null,"Could not convert object to the appropriate class!","Problem Converting Object Read From File!",JOptionPane.ERROR_MESSAGE); }
        catch (ClassCastException | IOException cce) { cce.printStackTrace(); JOptionPane.showMessageDialog(null,"Could not convert the object to the appropriate class!","Problem Converting Object!", JOptionPane.ERROR_MESSAGE); }
    return null;
    }

    // To String
    @Override
    public String toString() {
        return  "Value: " + getValue()+
                "\nSuit: " + getSuit();
    }
}
