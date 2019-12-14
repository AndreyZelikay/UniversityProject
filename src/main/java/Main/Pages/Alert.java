package Main.Pages;

import Main.Pages.Controllers.AlertController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Alert {

    public static void show(String message) {
        FXMLLoader loader = new FXMLLoader(Alert.class.getResource("/FXML/alert.fxml"));
        Stage stage = new Stage();
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        AlertController controller = loader.getController();
        controller.setMessage(message);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
