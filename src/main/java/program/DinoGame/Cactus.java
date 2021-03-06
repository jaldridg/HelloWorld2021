package src.main.java.program.DinoGame;

import java.awt.*;
import src.main.java.program.DinoGame.DinoConstants;

public class Cactus {

    private final int pixelSize = DinoConstants.PIXEL_SIZE;
    private final int[][] cactusPixels = DinoConstants.CACTUS_PIXELS;

    private int xPos = DinoConstants.SCREEN_WIDTH + 100;

    public void paintCactus(Graphics g) {
        int height = (cactusPixels.length - 3) * pixelSize;
        for(int i = 0; i < cactusPixels[0].length; i++) {
            for(int j = 0; j < cactusPixels.length; j++) {
                int color = cactusPixels[j][i] * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * pixelSize + xPos,
                        j * pixelSize + DinoConstants.GROUND_LEVEL - height,
                        pixelSize,
                        pixelSize);
            }
        }
    }

    public void moveCactus() {
        xPos -= pixelSize * 3;
        if(xPos < -100) {
            resetPosition();
        }
    }

    public void resetPosition() {
        xPos = DinoConstants.SCREEN_WIDTH + 100 + (int) (Math.random() * 500);
    }

    public int getTopBoundary() {
        int height = (cactusPixels.length - 3) * pixelSize;
        return DinoConstants.GROUND_LEVEL - height;
    }

    public int getLeftBoundary() {
        return xPos;
    }

}