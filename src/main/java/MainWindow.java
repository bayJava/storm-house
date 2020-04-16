import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainWindow {

    @FXML
    public void onStartClicked(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TitleWindow.fxml"));

        Stage titleWindow = new Stage();
        titleWindow.setScene(new Scene(loader.load()));

        titleWindow.setTitle("Storm The House");
        titleWindow.show();
    }
}
