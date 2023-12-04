package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenuGui extends JFrame {

    public MainMenuGui(ActionListener startGameListener) {
        initializeComponents(startGameListener);
        configureFrame();
    }

    private void initializeComponents(ActionListener startGameListener) {
        JLabel startLabel = new JLabel("Click anywhere to start");
        startLabel.setForeground(Color.WHITE);
        startLabel.setHorizontalAlignment(JLabel.CENTER);
        startLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGameListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
            }
        });

        JPanel labelPanel = new JPanel();
        labelPanel.add(startLabel);

        labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        add(labelPanel, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startGameListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
            }
        });
    }

    private void configureFrame() {
        setLayout(new BorderLayout());

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/assets/BlackjackBoard.png"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);

        add(backgroundLabel, BorderLayout.CENTER);

        setTitle("BlackJack!");
        setSize(1285, 1050); // Set a default size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenuGui(e -> System.out.println("Start button pressed")));
    }
}