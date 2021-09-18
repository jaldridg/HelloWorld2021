package program.DinoGame;

import java.awt.*;

public class Cactus {

    private final int pixelSize = main.java.program.DinoGame.DinoConstants.PIXEL_SIZE;
    private final int[][] cactusPixels = main.java.program.DinoGame.DinoConstants.CACTUS_PIXELS;

    private int xPos = main.java.program.DinoGame.DinoConstants.SCREEN_WIDTH + 100;
 
    public void paintCactus(Graphics g) {
        int height = (cactusPixels.length - 3) * pixelSize;
        for(int i = 0; i < cactusPixels[0].length; i++) {
            for(int j = 0; j < cactusPixels.length; j++) {
                int color = cactusPixels[j][i] * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * pixelSize + xPos, 
                           j * pixelSize + main.java.program.DinoGame.DinoConstants.GROUND_LEVEL - height,
                           pixelSize, 
                           pixelSize);
            }
        }
        System.out.println("xPos: "+ xPos);
    }

    public void moveCactus() {
        xPos -= pixelSize * 3;
        if(xPos < -100) {
            xPos = main.java.program.DinoGame.DinoConstants.SCREEN_WIDTH + 100 + (int) (Math.random() * 500);
        }
    }

    public int getTopBoundary() {
        int height = (cactusPixels.length - 3) * pixelSize;
        return main.java.program.DinoGame.DinoConstants.GROUND_LEVEL - height;
    }

    public int getLeftBoundary() {
        return xPos;
    }

}