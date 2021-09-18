package main.java.program.DinoGame;

import java.awt.*;
import java.awt.event.*;

public class DinoGame extends Canvas implements KeyListener {

    private int width = DinoConstants.SCREEN_WIDTH;
    private int height = DinoConstants.SCREEN_HEIGHT;

    private Dinosaur dino = new Dinosaur();
    private Cactus cactus = new Cactus();
    
    private long timer = 0;

    public DinoGame() {
        Frame frame = new Frame("Dino Game");
        setBackground(Color.white);

        addKeyListener(this);
        frame.add(this);
        frame.setSize(width, height);
        frame.setVisible(true);

        repaint();
    }

    public void paint(Graphics g) { }

    public void update(Graphics g) {
        timer = System.currentTimeMillis();

        if(timer % 25 == 0) {
        cactus.moveCactus();
        dino.moveDino();

        // Draw background because it's not actually white
        g.setColor(Color.white);
        g.fillRect(-1, -1, width + 2, height + 2);

        // Draw
        dino.paintDino(g);
        cactus.paintCactus(g);

        // Draw ground
        g.setColor(Color.black);
        g.fillRect(0, DinoConstants.GROUND_LEVEL, width, 3);
        }

        repaint();
    }

    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode() == 32) {
            dino.setDinoVelocity(18);
        }
    }

    public static void main(String[] args) {
        DinoGame dg = new DinoGame();
    }
}
