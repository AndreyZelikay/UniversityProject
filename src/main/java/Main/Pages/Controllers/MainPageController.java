package Main.Pages.Controllers;

import Functions.Parsers;
import Main.Pages.Alert;
import Main.Pages.ConfirmBox;
import Main.Pages.WorkShopPage;
import WorkShops.WorkShopList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.text.ParseException;

public class MainPageController {

    @FXML
    Button saveButton;

    @FXML
    ListView<String> listView;

    public boolean isChangesSaved;

    private WorkShopList shopList;

    public void setParameters(String parameters) throws IOException, ClassNotFoundException, ParseException {
        shopList = new WorkShopList();
        switch (parameters) {
            case "Parse from file":
                Parsers.parseWorkshops(shopList, 3);
                break;
            case "Parse from binary":
                shopList.deserializeBinary();
                break;
            case "Parse from xml":
                shopList.deserializeXML();
                break;
        }
        fillListView();
    }

    private void fillListView(){
        listView.getItems().clear();
        for(int i = 0; i < shopList.getSize(); i++){
            listView.getItems().add(shopList.get(i).getName());
            listView.setOnMouseClicked(e -> {
                try {
                    WorkShopPage.show(shopList.get(listView.getSelectionModel().getSelectedIndex()));
                    fillListView();
                } catch (IOException ex) {
                    Alert.show("Can not open this page!");
                }
            });
        }
    }

    public void onSaveButtonClick(){
        String response = ConfirmBox.show("Save to file" , "Save to binary", "Save to xml");
        try {
            switch (response){
                case "Save to file":
                    shopList.writeToFiles();
                    break;
                case "Save to binary":
                    shopList.serializeBinary();
                    break;
                case "Save to xml":
                    shopList.serializeXML();
                    break;
            }
        } catch (IOException e) {
            Alert.show("Exception in serialize");
        }
        isChangesSaved = true;
        saveButton.setDisable(true);
    }
}
