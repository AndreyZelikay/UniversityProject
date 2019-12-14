package Main.Pages.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class AlertController {

    @FXML
    Button okButton;

    @FXML
    Label message;


    public void onOkButtonClick(){
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    public void setMessage(String text){
        message.setText(text);
    }
}
