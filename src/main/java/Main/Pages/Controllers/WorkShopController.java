package Main.Pages.Controllers;

import Functions.Parsers;
import Functions.Validators;
import Main.Pages.Alert;
import WorkShops.AutoRepairShop.AutoRepairShop;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.ParseException;

public class WorkShopController {

    @FXML
    Button submitButton;

    @FXML
    Label name;

    @FXML
    TextField address;

    @FXML
    TextField date;

    @FXML
    TextField nameField;

    private AutoRepairShop repairShop;

    public void submit(){
        try {
            repairShop.setOpeningDate(Parsers.parseDate(date.getText()));
            repairShop.setName(nameField.getText());
            repairShop.setAddress(address.getText());
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.close();
        } catch (ParseException | IllegalArgumentException e){
            Alert.show("Illegal arguments");
        }
    }

    public void setInfo(AutoRepairShop repairShop){
        this.repairShop = repairShop;
        name.setText(repairShop.getName());
        nameField.setText(repairShop.getName());
        address.setText(repairShop.getAddress());
        date.setText(repairShop.getOpeningDate());
    }
}
