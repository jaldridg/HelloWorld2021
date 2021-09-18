package src.main.java.program.DinoGame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class DinoGame extends Canvas implements KeyListener {

    private int width = DinoConstants.SCREEN_WIDTH;
    private int height = DinoConstants.SCREEN_HEIGHT;

    private Dinosaur dino = new Dinosaur();
    private Cactus cactus = new Cactus();
    
    private double fps = 30;
    private long timer = 0;

    public DinoGame() {
        JFrame frame = new JFrame("Dino Game");
        setBackground(Color.white);

        addKeyListener(this);
        frame.add(this);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        repaint();
    }

    public void update(Graphics g) {
        timer = System.currentTimeMillis();

        if(timer % 30 == 0) {
            cactus.moveCactus();
            dino.moveDino();

            // Draw background because it's not actually white
            g.setColor(Color.white);
            g.fillRect(-1, -1, width + 2, height + 2);

            // Draw stuff
            dino.paintDino(g);
            cactus.paintCactus(g);

            // Draw ground
            g.setColor(Color.black);
            g.fillRect(0, DinoConstants.GROUND_LEVEL, width, 3);

            // Test boundaries
            g.setColor(Color.red);
            g.drawLine(0, cactus.getTopBoundary(), width, cactus.getTopBoundary());
            g.drawLine(cactus.getLeftBoundary(), 0, cactus.getLeftBoundary(), height);   
            g.drawLine(0, dino.getBottomBoundary(), width, dino.getBottomBoundary());
            g.drawLine(dino.getRightBoundary(), 0, dino.getRightBoundary(), height);  
            
            if(cactus.getTopBoundary() < dino.getBottomBoundary() && 
            cactus.getLeftBoundary() < dino.getRightBoundary()) {
                fps = 1 / Integer.MAX_VALUE;
                //dino.paintDeadDino(g);
            }   
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode() == 32) {
            dino.setDinoVelocity(26);
        }
    }

    public static void main(String[] args) {
        DinoGame dg = new DinoGame();
    }
}
