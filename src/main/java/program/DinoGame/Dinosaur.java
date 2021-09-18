package main.java.program.DinoGame;

import java.awt.*;

public class Dinosaur {

    final int pixelSize = DinoConstants.PIXEL_SIZE;
    final int[][] dinosaurPixels = DinoConstants.DINOSAUR_PIXELS;

    private int height = (dinosaurPixels.length - 3) * pixelSize;
    private int defaultHeight = height;
    private int vel = 0;

    public void paintDino(Graphics g) {
        for(int i = 0; i < dinosaurPixels[0].length; i++) {
            for(int j = 0; j < dinosaurPixels.length; j++) {
                int color = dinosaurPixels[j][i] * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * pixelSize + DinoConstants.GROUND_LEVEL - 200, 
                           j * pixelSize + DinoConstants.GROUND_LEVEL - height, 
                           pixelSize, 
                           pixelSize);
            }
        }
    }

    public void moveDino() {
        height += vel;
        vel -= 1;
        if(defaultHeight > height) {
            setDinoVelocity(0);
        }
    }    


    private void setDinoPosition(int velocity) {
        height = height;
    }

    public void setDinoVelocity(int velocity) {
        vel = velocity;
    }
}
