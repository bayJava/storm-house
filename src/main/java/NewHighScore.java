import java.io.IOException;
import java.util.List;

import Model.HighScore;
import Model.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class NewHighScore {

    @FXML TextField playername;
    @FXML Label scoreId;
    @FXML Label validName;
    @FXML Label message; 

    HighScore highScores = HighScore.getInstance();
    Score score;

      /**
        1.Load Scores from file
        2.get scores list from getScoresList
        3.Looping through scores list
        4.Check the UserValiad or not and And QualifiesOrNot (findIfScoreQualifiesAsHigh) 
        5.If Qualifies thenDisplay the his/her Score 
        6.And show Message Qualified or not
         */

    @FXML
    public void userQualifiesOrNot(ActionEvent ae) throws IOException{
        highScores.loadScores("src/main/resources/SaveScoresTestData.txt");
        List<Score> playersList = highScores.getScoresList();
        //System.out.println("If Text field:"+playername.getText()); 
        Alert alertBox = new Alert(AlertType.ERROR);

        if (playername.getText().isEmpty()) {
            validName.setText("Please Enter name");
        } 
        for(int i=0; i < playersList.size(); i++ ){ 
            if(playersList.get(i).getName().equals(playername.getText())) {
                validName.setVisible(false);
                score = new Score(playersList.get(i).getName(),playersList.get(i).getScore(),playersList.get(i).getDifficultyType());
                if(highScores.findIfScoreQualifiesAsHigh(score) == true){
                     Alert alert = new Alert(AlertType.INFORMATION);
                     scoreId.setText(""+playersList.get(i).getScore());  
                     alert.setHeaderText("Results:");
                     alert.setContentText("Your Qualified in this Game");
                     alert.show();
                 //   message.setText("Your Qualified in this Game");
                 //    scoreId.setText(""+playersList.get(i).getScore());  
                }  
            }else if(!playersList.contains(playername.getText())){
                validName.setText("Please Enter Valid name");
            } 
        }
    }

}