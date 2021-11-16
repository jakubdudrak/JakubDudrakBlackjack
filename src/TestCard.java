import java.io.*;
import java.util.Scanner;

public class TestCard {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        Deck deck = new Deck();
        Player player = new Player("Jakub", 500);
        Dealer house = new Dealer();

       /*
        Deck deck1 = new Deck();
        System.out.println("\n" + deck1);
        */
       // boolean gameOver =
       // while (!gameOver)
        System.out.println("Dealer cards");
        System.out.print(house.getCards() + "\n\n");

        System.out.println("Player cards");
        System.out.print(player.getCards() + "\n\n");
/*
        File saveFile = new File("playerInfo.dat");
        FileOutputStream savePlayerFileStr = new FileOutputStream(saveFile);
        ObjectOutputStream savePlayerStream = new ObjectOutputStream(savePlayerFileStr);

        FileInputStream readPlayerFileStr= new FileInputStream("playerInfo.dat");
        ObjectInputStream readPlayerStream = new ObjectInputStream(readPlayerFileStr);


        int answer;
        System.out.println("Enter player ID (0 to generate a new Player): ");
        answer = input.nextInt();

        while(answer == 0){
            System.out.println("Enter a new player name: ");
            input.nextLine();
            String name = input.nextLine();

            System.out.println("Enter balance for new player");
            int balance = input.nextInt();

            Player newPlayer = new Player(name, balance);
            savePlayerStream.writeObject(newPlayer);

            System.out.println("Enter player ID (0 to generate a new Player): ");
            answer = input.nextInt();
        }

        System.out.println((Player) readPlayerStream.readObject());
*/



    }
}
