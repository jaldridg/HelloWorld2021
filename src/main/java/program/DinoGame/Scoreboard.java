package main.java.program.DinoGame;

import java.awt.*;

public class ScoreBoard{
    final int pixelSize = 2*DinoConstants.PIXEL_SIZE;

    int Score = 0;
    int highScore = 0;
    String allScore = Score + " " + highScore;

    public String printScore{
        if(){
            Score++;
        }
        else{
            highScore = Score;
            Score = 0;
        }

        return allScore
    }

}