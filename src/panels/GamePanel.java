package panels;

import game.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 900;
    static final int SCREEN_HEIGHT = 500;

    static final int LIMIT_TIME = 60; // turn-timer
    BufferedImage background;

    Timer timer;
    Random random;

    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new GameKeyAdapter());

        try {
            String filename=".\\src\\resource\\background.png"; // 파일의 경로
            background = ImageIO.read(new File(filename)); //이미지 파일을 불러오는 IO 메소드
            //파일경로의 이미지 파일을 읽는다.
        } catch (IOException e) {
            e.printStackTrace();
        }
        startGame();
    }

    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null); //background를 그려줌
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
