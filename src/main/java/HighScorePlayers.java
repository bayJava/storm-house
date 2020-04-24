import java.io.IOException;
import java.util.List;

import Model.HighScore;
import Model.Score;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HighScorePlayers {

    @FXML
    VBox vrank;
    @FXML
    VBox vname;
    @FXML
    VBox vscore;

    HighScore highScores = HighScore.getInstance();
    Score score;

    @FXML
    void initialize() throws IOException {
        /**
        1.Load Scores from file
        2.get scores list from getScoresList
        3.Looping through scores list
        4.Load scores
        5.Check findIfScoreQualifiesAsHigh 
        6.display rank, name and scores as labels from scores list
         */
        highScores.loadScores("src/main/resources/SaveScoresTestData.txt");
        List<Score> slist = highScores.getScoresList();
        
        int r = 1;    
        for (int i = 0; i < slist.size(); ++i) {
            score = new Score(slist.get(i).getName(),slist.get(i).getScore(),slist.get(i).getDifficultyType());
            //highScores.addHighScore(score);
            if (highScores.findIfScoreQualifiesAsHigh(score) == true) {
                Label rank = new Label();
                Label name = new Label();
                Label scoreLabel = new Label();

                rank.setText(""+(r+i));
                vrank.getChildren().add(rank);

                name.setText(slist.get(i).getName());
                vname.getChildren().add(name);
                
                scoreLabel.setText(String.valueOf(slist.get(i).getScore()));
                vscore.getChildren().add(scoreLabel);
            }

        }
        System.out.println("high Scores"+score.getName());
        
    }

}