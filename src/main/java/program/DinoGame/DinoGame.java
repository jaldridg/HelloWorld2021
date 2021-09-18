package main.java.program.DinoGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class DinoGame extends Canvas implements KeyListener {

    final int WIDTH = 1000;
    final int HEIGHT = 500;

    Dinosaur dino = new Dinosaur();
    
    public DinoGame() {
        JFrame frame = new JFrame("Dino Game");

        frame.add(this);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);

        frame.setBackground(Color.white);

        repaint();
    }

    public void paint(Graphics g) {
        // Draw background because it's not actually white
        g.setColor(Color.white);
        g.fillRect(-1, -1, WIDTH + 2, HEIGHT + 2);

        // Draw dinosaur

        // Draw ground
        g.setColor(Color.black);
        g.fillRect(0, DinoConstants.GROUND_LEVEL, WIDTH, 3);
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
