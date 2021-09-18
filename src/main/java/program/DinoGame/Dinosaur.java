package main.java.program.DinoGame;

import java.awt.*;

public class Dinosaur {

    final int pixelSize = DinoConstants.PIXEL_SIZE;
    final int[][] dinosaurPixels = DinoConstants.DINOSAUR_PIXELS;

    public void paintDino(Graphics g) {
        int dinosaurHeight = (dinosaurPixels.length - 3) * pixelSize;
        for(int i = 0; i < dinosaurPixels.length; i++) {
            for(int j = 0; j < dinosaurPixels[0].length; j++) {
                int color = Math.abs(dinosaurPixels[j][i] - 1) * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * pixelSize + DinoConstants.GROUND_LEVEL - 200, 
                           j * pixelSize + DinoConstants.GROUND_LEVEL - dinosaurHeight, 
                           pixelSize, 
                           pixelSize);
            }
        }
    }
    
}
