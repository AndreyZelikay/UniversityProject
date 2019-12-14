package Main.Pages;

import Main.Pages.Controllers.LoginPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInPage {

    public static void show() throws IOException {
        FXMLLoader loader = new FXMLLoader(LogInPage.class.getResource("/FXML/login.fxml"));
        Parent root = loader.load();
        final LoginPageController controller = loader.getController();
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setOnCloseRequest(e -> {
            e.consume();
            if(controller.isValid()){
               stage.close();
            } else{
                stage.close();
                System.exit(0);
            }
        });
        stage.showAndWait();
    }
}
