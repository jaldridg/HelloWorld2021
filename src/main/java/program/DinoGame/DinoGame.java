package main.java.program.DinoGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class DinoGame extends Canvas implements KeyListener {

    final int PIXEL_SIZE = 5;
    
    public DinoGame() {
        JFrame frame = new JFrame("Dino Game");

        frame.add(this);
        frame.setSize(1000, 500);
        frame.setVisible(true);

        repaint();
    }

    public void paint(Graphics g) {
        for(int i = 0; i < PixelArrays.DinosaurPixels.length; i++) {
            for(int j = 0; j < PixelArrays.DinosaurPixels[0].length; j++) {
                int color = PixelArrays.DinosaurPixels[i][j] * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
    }

    public void update(Graphics g) {

    }

    public void keyTyped(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }

    public static void main(String[] args) {
        DinoGame dg = new DinoGame();
    }
}
