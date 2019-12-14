package Main;

import Main.Pages.ConfirmBox;
import Main.Pages.MainPage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String response = ConfirmBox.show("Parse from file", "Parse from binary", "Parse from xml");
        System.out.println("asodalsdj");
        MainPage mainPage = new MainPage(primaryStage, response);
        mainPage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
