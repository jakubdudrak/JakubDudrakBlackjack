import javax.swing.*;
import java.awt.*;
//https://tips4java.wordpress.com/2008/10/12/background-panel/ class was refactored to fit this project
public class BackgroundPanel extends JPanel{

        private Image background;

        public BackgroundPanel(Image background){
            this.background = background;
            setLayout( new BorderLayout() );
        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(background, 0, 0, null);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(background.getWidth(this), background.getHeight(this));
        }

}
