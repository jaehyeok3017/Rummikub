package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 900;
    static final int SCREEN_HEIGHT = 500;

    static final int LIMIT_TIME = 60; // turn-timer

    Timer timer;
    Random random;

    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new GameKeyAdapter());
        startGame();
    }

    public void startGame(){

    }

    public void paintComponent(Graphics g){

    }

    public void draw(Graphics g){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class GameKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
        }
    }
}
