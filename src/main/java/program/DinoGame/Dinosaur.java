package src.main.java.program.DinoGame;

import java.awt.*;
import src.main.java.program.DinoGame.DinoConstants;

public class Dinosaur {

    final int pixelSize = DinoConstants.PIXEL_SIZE;
    final int[][] dinosaurPixelsFrameOne = DinoConstants.DINOSAUR_PIXELS_FRAME_ONE;
    final int[][] dinosaurPixelsFrameTwo = DinoConstants.DINOSAUR_PIXELS_FRAME_TWO;
    final int[][] deadDinosaurPixels = DinoConstants.DEAD_DINOSAUR_PIXELS;

    private int height = (dinosaurPixelsFrameOne.length - 3) * pixelSize;
    private int defaultHeight = height;
    private int vel = 0;

    private int frame = 0;

    public void paintDino(Graphics g) {
        int[][] pixels = new int[dinosaurPixelsFrameOne.length][dinosaurPixelsFrameOne[0].length];
        if(!isJumping()) {
            frame++;
            if(frame < 5) {
                pixels = dinosaurPixelsFrameOne;
            } else if (frame < 9) {
                pixels = dinosaurPixelsFrameTwo;
            } else{
                pixels = dinosaurPixelsFrameTwo;
                frame = 0;
            }
        } else {
            pixels = dinosaurPixelsFrameTwo;
        }
        
        for(int i = 0; i < pixels[0].length; i++) {
            for(int j = 0; j < pixels.length; j++) {
                int color = pixels[j][i] * 255;
                g.setColor(new Color(color, color, color));
                g.fillRect(i * pixelSize + 100, 
                           j * pixelSize + DinoConstants.GROUND_LEVEL - height, 
                           pixelSize, 
                           pixelSize);
            }
        }
    }

    public void paintDeadDino(Graphics g) {
        for(int i = 0; i < deadDinosaurPixels[0].length; i++) {
            for(int j = 0; j < deadDinosaurPixels.length; j++) {
                int color = deadDinosaurPixels[j][i] * 255;
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
        vel -= 1;
        if(defaultHeight > height) {
            setDinoVelocity(0);
            resetPosition();
        }
    }    

    private boolean isJumping() {
        return defaultHeight != height;
    }

    public void jump() {
        if(!isJumping()) {
            setDinoVelocity(pixelSize * 4);
        }
    }

    public void resetPosition() {
        height = defaultHeight;
    }

    public int getDinoVelocity() {
        return vel;
    }

    public void setDinoVelocity(int velocity) {
        vel = velocity;
    }

    public int getBottomBoundary() {
        return DinoConstants.GROUND_LEVEL - height + (pixelSize * dinosaurPixelsFrameOne.length);
    }

    public int getRightBoundary() {
        return 100 + (pixelSize * dinosaurPixelsFrameOne[0].length);
    }
}
