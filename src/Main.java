import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Dealer house = new Dealer();
        JFrame mainMenu = new JFrame("BlackJack!");
        JButton startGame = new JButton("Start Game");
        JPanel controls = new JPanel();{

            controls.add(startGame);
            startGame.setBounds(550,850,100,40);

            //controls.add(backButton);
            //backButton.setBounds(650,850,100,40);
        }

        JPanel backgroundMenu = new JPanel(){
            Image background = new ImageIcon(("Assets\\CardsImgs\\BlackJackBoard.png")).getImage();


            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize(){
                return new Dimension(background.getWidth(this), background.getHeight(this));
            }
        };

        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setSize(1285,1050);

        mainMenu.add(backgroundMenu);
        mainMenu.add(controls, BorderLayout.SOUTH);

        mainMenu.setVisible(true);
        Player player = new Player(JOptionPane.showInputDialog("Please Enter a Name"), Integer.parseInt(JOptionPane.showInputDialog("Please Enter Balance")));

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GameGui game = new GameGui();
                if(game.isGameOver()) {
                    for (int i = 0; i < player.getCards().size(); i++) {
                        deck.getCards().add(player.getCards().get(i));
                        player.getCards().remove(i);
                    }
                    for (int i = 0; i < house.getCards().size(); i++) {
                        deck.getCards().add(house.getCards().get(i));
                        house.getCards().remove(i);
                    }
                    deck.shuffle();
                    game.renderFrameGame(player, house);
                }
                else{
                    deck.shuffle();
                    game.renderFrameGame(player, house);
                }
            }
        });


/*
        game.renderFrameGame(player, deck, house);
*/
//        System.exit(0);
    }
}