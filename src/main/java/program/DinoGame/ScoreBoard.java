package src.main.java.program.DinoGame;

public class ScoreBoard{
    int score = 0;
    int highScore = 0;

    public void addScore() {
        score++;
    }

    public int getHighScore(){
        return highScore;
    }

    public int getScore() {
        return score;
    }

    public void setHighScore() {
        if(score > highScore) {
            highScore = score;
        }
        score = 0;
    }
}