package src.main.java.program.DinoGame;

import java.awt.*;
import java.awt.event.*;
import src.main.java.program.DinoGame.ScoreBoard;

import javax.swing.*;
import src.main.java.program.DinoGame.Dinosaur;
import src.main.java.program.DinoGame.DinoConstants;
import src.main.java.program.DinoGame.Cactus;

public class DinoGame extends Canvas implements KeyListener {

    private int width = DinoConstants.SCREEN_WIDTH;
    private int height = DinoConstants.SCREEN_HEIGHT;

    private Dinosaur dino = new Dinosaur();
    private Cactus cactus = new Cactus();
    private ScoreBoard score = new ScoreBoard();

    private double fps = 30;
    private long timer = 0;

    private boolean alive = true;

    public DinoGame() {
        setBackground(Color.white);

        addKeyListener(this);
        setSize(width, height);
        setVisible(true);

        repaint();
    }

    public void update(Graphics g) {
        timer = System.currentTimeMillis();
        if(timer % fps == 0 && alive) {
            cactus.moveCactus();
            dino.moveDino();

            g.setColor(Color.white);
            g.fillRect(-1, -1, width + 2, height + 2);

            // Draw stuff
            dino.paintDino(g);
            cactus.paintCactus(g);

            // Draw ground
            g.setColor(Color.black);
            g.fillRect(0, DinoConstants.GROUND_LEVEL, width, 3);

            // Draw score
            score.addScore();
            Font font = new Font(Font.SERIF, Font.BOLD, DinoConstants.PIXEL_SIZE * 4);
            g.setFont(font);
            g.drawString("HI  " + score.getHighScore() + "   " + score.getScore(), width - 200, 50);

            if(isColliding())
            {
                dino.paintDeadDino(g);

                // Redraw ground
                g.setColor(Color.black);
                g.fillRect(0, DinoConstants.GROUND_LEVEL, width, 3);

                score.setHighScore();
                alive = false;
            }
        }
        repaint();
    }
    private boolean isColliding() {
        boolean verticalIntersection = cactus.getTopBoundary() < dino.getBottomBoundary();
        boolean horizontalIntersection = cactus.getLeftBoundary() < dino.getRightBoundary();
        int cactusWidth = DinoConstants.PIXEL_SIZE * DinoConstants.CACTUS_PIXELS[0].length;
        int dinoWidth = DinoConstants.PIXEL_SIZE * DinoConstants.DINOSAUR_PIXELS_FRAME_ONE[0].length;
        boolean pastTheCactus = dino.getRightBoundary() - cactus.getLeftBoundary() > cactusWidth + dinoWidth;
        return verticalIntersection && horizontalIntersection && !pastTheCactus;
    }

    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 32) {
            if(alive) {
                dino.jump();
            } else {
                dino.resetPosition();
                cactus.resetPosition();
                alive = true;
            }
        }
    }

    public static void main(String[] args) {
        DinoGame dg = new DinoGame();
    }
}