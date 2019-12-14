package Main.Pages;

import Main.Pages.Controllers.WorkShopController;
import WorkShops.AutoRepairShop.AutoRepairShop;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class WorkShopPage {

    public static void show(AutoRepairShop repairShop) throws IOException {
        FXMLLoader loader = new FXMLLoader(Alert.class.getResource("/FXML/workShop.fxml"));
        Parent root = loader.load();
        WorkShopController controller = loader.getController();
        controller.setInfo(repairShop);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
