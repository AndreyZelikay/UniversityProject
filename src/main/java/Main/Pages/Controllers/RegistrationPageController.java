package Main.Pages.Controllers;

import DAO.UserDaoImpl;
import Functions.Validators;
import Main.Pages.Alert;
import Models.User;
import Utils.MD5Util;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.NoResultException;
import java.io.IOException;


public class RegistrationPageController {

    @FXML
    TextField name;
    @FXML
    TextField password;
    @FXML
    TextField confirmPassword;
    @FXML
    Button back;
    @FXML
    Button signUp;
    @FXML
    Label label;

    public void onSignUpClick() throws IOException {
        if(!password.getText().equals(confirmPassword.getText())){
            label.setText("Passwords are different");
            return;
        }
        if(!Validators.validatePassword(password.getText()) || name.getText().length() < 4){
            label.setText("Incorrect data");
            return;
        }
        UserDaoImpl userDao = new UserDaoImpl();
        try{
            userDao.findByName(name.getText());
            label.setText("User with this name exist");
        } catch (NoResultException e){
            User user = new User();
            user.setPassword(MD5Util.encrypt(password.getText()));
            user.setName(name.getText());
            userDao.save(user);
            Alert.show("Successful registration!");
            onBackClick();
        }
    }

    public void onBackClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(LoginPageController.class.getResource("/FXML/login.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) back.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
