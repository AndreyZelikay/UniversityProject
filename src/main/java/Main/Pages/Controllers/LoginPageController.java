package Main.Pages.Controllers;

import Functions.Validators;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginPageController {

    @FXML
    TextField name;
    @FXML
    TextField password;
    @FXML
    Button signIn;
    @FXML
    Label label;

    private boolean isValid;

    public void onSignInClick(){
        if(!Validators.validateUser(name.getText(), password.getText())){
            label.setText("Invalid username or password!");
            isValid = false;
        } else {
            Stage stage = (Stage) signIn.getScene().getWindow();
            isValid = true;
            stage.close();
        }
    }

    public boolean isValid(){
        return isValid;
    }
}
