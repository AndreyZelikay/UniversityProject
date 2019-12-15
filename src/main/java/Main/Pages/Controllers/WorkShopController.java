package Main.Pages.Controllers;

import Functions.Parsers;
import Functions.Validators;
import Main.Pages.Alert;
import Utils.VBoxUtil;
import WorkShops.AutoRepairShop.AutoRepairShop;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

    @FXML
    VBox cars;
    @FXML
    VBox numbers;
    @FXML
    VBox masters;

    private AutoRepairShop repairShop;

    public void submit(){
        try {
            repairShop.setOpeningDate(Parsers.parseDate(date.getText()));
            repairShop.setName(nameField.getText());
            repairShop.setAddress(address.getText());
            repairShop.getTelephoneNumbers().clear();
            repairShop.setMasters(Parsers.parseMastersFromVBox(masters));
            repairShop.setTypeOfRepairingCars(Parsers.parseCarsFromVBox(cars));
            repairShop.setTelephoneNumbers(Parsers.parseNumbersFromVBox(numbers));
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.close();
        } catch (ParseException e){
            Alert.show("Illegal arguments");
        } catch (IllegalArgumentException e){
            Alert.show(e.getMessage());
        }
    }

    public void setInfo(AutoRepairShop repairShop){
        this.repairShop = repairShop;
        name.setText(repairShop.getName());
        nameField.setText(repairShop.getName());
        address.setText(repairShop.getAddress());
        date.setText(repairShop.getOpeningDateString());
        VBoxUtil.createVBox(repairShop.getTypeOfRepairingCars(), cars);
        VBoxUtil.createVBox(repairShop.getTelephoneNumbers(), numbers);
        VBoxUtil.createVBox(repairShop.getMasters(), masters);
    }
}
