package main.java.program.DinoGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class DinoGame extends Canvas implements KeyListener {

    final int PIXEL_SIZE = 5;
    final int WIDTH = 1000;
    final int HEIGHT = 500;

    final int GROUND_LEVEL = 300;

    final int[][] dinosaurPixels = PixelArrays.DINOSAUR_PIXELS;
    
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
        int dinosaurHeight = (dinosaurPixels.length - 3) * PIXEL_SIZE;
        for(int i = 0; i < dinosaurPixels.length; i++) {
            for(int j = 0; j < dinosaurPixels[0].length; j++) {
                int color = Math.abs(dinosaurPixels[j][i] - 1) * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * PIXEL_SIZE + GROUND_LEVEL - 200, 
                           j * PIXEL_SIZE + GROUND_LEVEL - dinosaurHeight, 
                           PIXEL_SIZE, 
                           PIXEL_SIZE);
            }
        }
        // Draw ground
        g.setColor(Color.black);
        g.fillRect(0, GROUND_LEVEL, WIDTH, 3);
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
