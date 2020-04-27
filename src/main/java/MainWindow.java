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
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainWindow {

    //@FXML ImageView imgView;
    @FXML Label Rank;
    @FXML Label Name;
    @FXML Label Score;
    @FXML Label scoreId;
    @FXML Label message;


    @FXML TextField playername; 

    HighScore highScores = HighScore.getInstance();
    Label labelresponse= new Label();

    @FXML
    void onGreetClicked(ActionEvent event) {
        var alert = new Alert(AlertType.INFORMATION, "Hello, world!");
        alert.setHeaderText(null);
        alert.show();
    }

    @FXML
    public void onLoadHighScoreScreen(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HighScorePlayers.fxml"));

        Stage highscoreData = new Stage();
        highscoreData.setScene(new Scene(loader.load()));
        highscoreData.show();

    }

    @FXML
    public void onNewHighScore(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewHighScore.fxml"));

        Stage newHighscore = new Stage();
        newHighscore.setScene(new Scene(loader.load()));

        newHighscore.show();

    }

    @FXML
    public void onPlayGame(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayGame.fxml"));

        Stage instruction = new Stage();

        instruction.setScene(new Scene(loader.load()));

        instruction.setTitle("Game"); 
        instruction.show();

    }

    @FXML
    public void onInstructions(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Instructions.fxml"));

        Stage instruction = new Stage();

        instruction.setScene(new Scene(loader.load()));

        instruction.setTitle("Instructions"); 
        instruction.show();

    }

    @FXML
    public void onAbout(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("About.fxml"));

        Stage instruction = new Stage();

        instruction.setScene(new Scene(loader.load()));

        instruction.setTitle("About"); 
        instruction.show(); 
    }

}


