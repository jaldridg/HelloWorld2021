package src.main.java.program.DinoGame;

import java.awt.*;

public class Dinosaur {

    final int pixelSize = DinoConstants.PIXEL_SIZE;
    final int[][] dinosaurPixels = DinoConstants.DINOSAUR_PIXELS;
    final int[][] deadDinosaurPixels = DinoConstants.DEAD_DINOSAUR_PIXELS;

    private int height = (dinosaurPixels.length - 3) * pixelSize;
    private int defaultHeight = height;
    private int vel = 0;

    public void paintDino(Graphics g) {
        for(int i = 0; i < dinosaurPixels[0].length; i++) {
            for(int j = 0; j < dinosaurPixels.length; j++) {
                int color = dinosaurPixels[j][i] * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * pixelSize + 100, 
                           j * pixelSize + DinoConstants.GROUND_LEVEL - height, 
                           pixelSize, 
                           pixelSize);
            }
        }
    }

    public void paintDeadDino(Graphics g) {
        for(int i = 0; i < dinosaurPixels[0].length; i++) {
            for(int j = 0; j < dinosaurPixels.length; j++) {
                int color = dinosaurPixels[j][i] * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * pixelSize + 100, 
                           j * pixelSize + DinoConstants.GROUND_LEVEL - height, 
                           pixelSize, 
                           pixelSize);
            }
        }
    }

    public void moveDino() {
        height += vel;
        vel -= 2;
        if(defaultHeight > height) {
            setDinoVelocity(0);
        }
    }    

    public int getDinoVelocity() {
        return vel;
    }

    public void setDinoVelocity(int velocity) {
        vel = velocity;
    }

    public int getBottomBoundary() {
        return DinoConstants.GROUND_LEVEL - height + (pixelSize * dinosaurPixels.length);
    }

    public int getRightBoundary() {
        return 100 + (pixelSize * dinosaurPixels[0].length);
    }
}
