package main.java.program.DinoGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class DinoGame extends Canvas implements KeyListener {

    private int width = DinoConstants.SCREEN_WIDTH;
    private int height = DinoConstants.SCREEN_HEIGHT;

    private Dinosaur dino = new Dinosaur();
    
    public DinoGame() {
        JFrame frame = new JFrame("Dino Game");

        frame.add(this);
        frame.setSize(width, height);
        frame.setVisible(true);

        frame.setBackground(Color.white);

        repaint();
    }

    public void paint(Graphics g) {
        // Draw background because it's not actually white
        g.setColor(Color.white);
        g.fillRect(-1, -1, width + 2, height + 2);

        // Draw dinosaur
        dino.paintDino(g);

        // Draw ground
        g.setColor(Color.black);
        g.fillRect(0, DinoConstants.GROUND_LEVEL, width, 3);
    }

    public void update(Graphics g) {

    }

    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { 

    }

    public static void main(String[] args) {
        DinoGame dg = new DinoGame();
    }
}
