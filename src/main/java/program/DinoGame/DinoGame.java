package main.java.program.DinoGame;

import java.awt.*;
import java.awt.event.*;

public class DinoGame extends Canvas implements KeyListener {
    
    public DinoGame() {
        Frame frame = new Frame("Dino Game");

        frame.add(this);
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {

    }

    public void update(Graphics g) {

    }

    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { 
        repaint();
    }
}
