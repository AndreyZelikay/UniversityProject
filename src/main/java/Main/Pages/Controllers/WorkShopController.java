package Main.Pages.Controllers;

import Functions.Parsers;
import Functions.Validators;
import Main.Pages.Alert;
import WorkShops.AutoRepairShop.AutoRepairShop;
import WorkShops.AutoRepairShop.Master.Master;
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
    ListView<String> cars;
    @FXML
    VBox numbers;
    @FXML
    ListView<Master> masters;

    private AutoRepairShop repairShop;

    public void submit(){
        try {
            repairShop.setOpeningDate(Parsers.parseDate(date.getText()));
            repairShop.setName(nameField.getText());
            repairShop.setAddress(address.getText());
            for(int i = 0; i < numbers.getChildren().size(); i++){
                HBox hBox = (HBox) numbers.getChildren().get(i);
                TextField textField = (TextField) hBox.getChildren().get(0);
                Validators.validateNumber(textField.getText());
                repairShop.getTelephoneNumbers().set(i,textField.getText());
            }
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
        for(String number: repairShop.getTelephoneNumbers()){
            HBox hBox = new HBox();
            Button button = new Button("-");
            button.setOnAction(e->numbers.getChildren().remove(hBox));
            hBox.getChildren().addAll(new TextField(number), button);
            numbers.getChildren().add(hBox);
        }
    }
}
