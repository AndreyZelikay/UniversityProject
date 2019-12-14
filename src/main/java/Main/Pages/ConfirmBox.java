package Main.Pages;

import Main.Pages.Controllers.ConfirmBoxController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmBox {

    public static String show(String firstChoice, String secondChoice, String thirdChoice){
        FXMLLoader loader = new FXMLLoader(ConfirmBox.class.getResource("/FXML/confirmBox.fxml"));
        try {
            Parent root = loader.load();
            ConfirmBoxController controller = loader.getController();
            controller.setOptions(firstChoice, secondChoice, thirdChoice);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        ConfirmBoxController controller = loader.getController();

        return controller.getResponse();
    }
}
