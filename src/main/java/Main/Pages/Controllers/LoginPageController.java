package Main.Pages.Controllers;

import Functions.Validators;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginPageController {

    @FXML
    TextField name;
    @FXML
    TextField password;
    @FXML
    Button signIn;
    @FXML
    Label label;
    @FXML
    Button signUp;

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

    public void onSignUpClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/FXML/registration.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) signIn.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public boolean isValid(){
        return isValid;
    }
}
