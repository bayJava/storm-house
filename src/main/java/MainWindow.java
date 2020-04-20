import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class MainWindow {

    @FXML
    void onGreetClicked(ActionEvent event) {
        var alert = new Alert(AlertType.INFORMATION, "Hello, world!");
        alert.setHeaderText(null);
        alert.show();

    }

    @FXML
    public void loadHighScore(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HighScoresData.fxml"));

        Stage highscoreData = new Stage();
        highscoreData.setScene(new Scene(loader.load()));

        highscoreData.show();

    }
}
