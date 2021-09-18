package src.main.java.program.DinoGame;
import src.main.java.program.DinoGame.DinoConstants;
import java.awt.*;

public class Scoreboard{
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