package Main.Pages;

import Main.Pages.Controllers.MainPageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class MainPage {

    private Stage window;

    private int counter;

    public MainPage(Stage primaryStage, String parameters) throws IOException {
        window = primaryStage;
        counter = 0;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/mainPage.fxml"));
        Parent root = loader.load();
        MainPageController controller = loader.getController();

        try {
            controller.setParameters(parameters);
        } catch (IOException|ClassNotFoundException | ParseException e) {
            window.close();
            Alert.show("Unable to parse!");
            System.exit(0);
        }
        window.setOnCloseRequest(e -> {
            e.consume();
            if(controller.isChangesSaved){
                window.close();
            } else{
                if(counter == 0) {
                    Alert.show("Save your changes!");
                    counter++;
                } else {
                    Alert.show("Save this f***ing changes!");
                }
            }
        });

        window.setScene(new Scene(root));
    }

    public void show(){
        window.show();
    }
}
