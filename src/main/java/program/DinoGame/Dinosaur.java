package main.java.program.DinoGame;

import java.awt.*;

public class Dinosaur {

    final int pixelSize = DinoConstants.PIXEL_SIZE;
    final int[][] dinosaurPixels = DinoConstants.DINOSAUR_PIXELS;

    private int height = (dinosaurPixels.length - 3) * pixelSize;

    public void paintDino(Graphics g) {
        for(int i = 0; i < dinosaurPixels[0].length; i++) {
            for(int j = 0; j < dinosaurPixels.length; j++) {
                int color = Math.abs(dinosaurPixels[j][i] - 1) * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * pixelSize + DinoConstants.GROUND_LEVEL - 200, 
                           j * pixelSize + DinoConstants.GROUND_LEVEL - height, 
                           pixelSize, 
                           pixelSize);
            }
        }
    }
    
}
