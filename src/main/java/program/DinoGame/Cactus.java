package src.main.java.program.DinoGame;
import src.main.java.program.DinoGame.DinoConstants;
import java.awt.*;
public class Cactus {

    final int pixelSize = DinoConstants.PIXEL_SIZE;
    final int[][] cactusPixels = DinoConstants.CACTUS_PIXELS;

    int xPos = DinoConstants.SCREEN_WIDTH / 2;
 
    public void paintCactus(Graphics g) {
        int height = (cactusPixels.length - 3) * pixelSize;
        for(int i = 0; i < cactusPixels.length; i++) {
            for(int j = 0; j < cactusPixels[0].length; j++) {
                int color = Math.abs(cactusPixels[j][i] - 1) * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * pixelSize + xPos, 
                           j * pixelSize + DinoConstants.GROUND_LEVEL - height, 
                           pixelSize, 
                           pixelSize);
            }
        }
    }

    public void moveCactus(int shiftAmount) {
        xPos += shiftAmount;
    }

}
