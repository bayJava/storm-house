import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import Model.DifficultyType;
import Model.HighScore;
import Model.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainWindow {

    @FXML Label Rank;
    @FXML Label Name;
    @FXML Label Score;
    @FXML Label scoreId;
    @FXML Label message;


    @FXML TextField playername; 

   // private ArrayList<Score> PlayersList = new ArrayList<Score>();
    HighScore highScores = HighScore.getInstance();
    Score score = new  Score(highScores);
    Label labelresponse= new Label();

    @FXML
    void onGreetClicked(ActionEvent event) {
        var alert = new Alert(AlertType.INFORMATION, "Hello, world!");
        alert.setHeaderText(null);
        alert.show();
    }

    @FXML
    public void loadHighScore(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HighScorePlayers.fxml"));
        HighScore.getInstance().loadScores("src/main/resources/SaveScoresData.txt");
        System.out.println(HighScore.getInstance().getScoresList());
        Stage highscoreData = new Stage();
        highscoreData.setScene(new Scene(loader.load()));
        highscoreData.show();

    }

    @FXML
    public void newHighScore(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewHighScore.fxml"));

        Stage newHighscore = new Stage();
        newHighscore.setScene(new Scene(loader.load()));

        newHighscore.show();

    }

    @FXML
    public void instructions(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Instructions.fxml"));
      //  VBox root = new VBox();
       // root.setStyle("-fx-padding: 10;" + 
      //                "-fx-border-color: blue;");
      //   Text  text = new Text();
     //    text.setStroke(Color.BLUE);
        Stage instruction = new Stage();
      //  Scene scene = new Scene(text);
     //   instruction.setScene(scene);
        instruction.setScene(new Scene(loader.load()));
     //   instruction.setScene(scene);
        instruction.setTitle("Instructions"); 
        instruction.show();

    }

}


