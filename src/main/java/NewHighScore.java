import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Model.HighScore;
import Model.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.*;
import javafx.scene.control.Alert.AlertType;

public class NewHighScore {

    @FXML TextField playername;
    @FXML Label newScore;
    @FXML Label playerName;
    @FXML Label message; 

    HighScore highScores = HighScore.getInstance();
    Score score;


    @FXML
    public void initialize() { 
    //    SoundPlay();
    }  
    
  /*  public void SoundPlay()
    {

    File audioFile = new File("src/main/resources/Sleep_Away.mp3");
    Media audio = new Media(audioFile.toURI().toString());
    MediaPlayer audioPlayer = new MediaPlayer(audio);
    audioPlayer.setAutoPlay(true);
    audioPlayer.play();
}*/
}
    
