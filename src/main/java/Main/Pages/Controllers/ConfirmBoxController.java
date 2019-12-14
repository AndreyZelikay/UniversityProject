package Main.Pages.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class ConfirmBoxController {

    @FXML
    Button submitButton;

    @FXML
    RadioButton button1;
    @FXML
    RadioButton button2;
    @FXML
    RadioButton button3;

    private String response;

    public void onButtonClick(){
        if(button1.isSelected()){
            response = button1.getText();
        }
        if(button2.isSelected()){
            response = button2.getText();
        }
        if(button3.isSelected()){
            response = button3.getText();
        }
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }

    public String getResponse(){
        return response;
    }

    public void setOptions(String option1, String option2, String option3){
        button1.setSelected(true);
        button1.setText(option1);
        button2.setText(option2);
        button3.setText(option3);
    }
}
