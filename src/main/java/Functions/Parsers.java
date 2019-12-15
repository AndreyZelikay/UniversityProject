package Functions;

import WorkShops.AutoRepairShop.AutoRepairShop;
import WorkShops.WorkShopList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.xml.bind.ValidationException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Parsers {

    public static Date parseDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        formatter.setLenient(false);
        return formatter.parse(date);
    }

    public static void parseWorkshops(WorkShopList workShopList, int number) throws IOException, ParseException {
        for(int i = 1; i <= number; i++){
            AutoRepairShop repairShop = new AutoRepairShop();
            repairShop.parseFromFile("input" + i + ".txt");
            workShopList.put(repairShop);
        }
    }

    public static ArrayList<String> parseNumbersFromVBox(VBox vBox) throws IllegalArgumentException {
        ArrayList<String> result = new ArrayList<>();
        for(Node children: vBox.getChildren().subList(0, vBox.getChildren().size() - 1)){
            String value = parseHBox((HBox) children);
            if(Validators.validateNumber(value)){
                result.add(value);
            } else {
                throw new IllegalArgumentException("unable to parse numbers");
            }
        }
        if(result.isEmpty()){
            throw new IllegalArgumentException("empty list");
        }
        return result;
    }

    public static ArrayList<String> parseCarsFromVBox(VBox vBox) throws IllegalArgumentException{
        ArrayList<String> result = new ArrayList<>();
        for(Node children: vBox.getChildren().subList(0, vBox.getChildren().size() - 1)) {
            String value = parseHBox((HBox) children);
            if(!value.isEmpty()){
                result.add(value);
            } else {
                throw new IllegalArgumentException("unable to parse empty car");
            }
        }
        if(result.isEmpty()){
            throw new IllegalArgumentException("empty list");
        }
        return result;
    }

    public static ArrayList<String> parseMastersFromVBox(VBox vBox){
        ArrayList<String> result = new ArrayList<>();
        for(Node children: vBox.getChildren().subList(0, vBox.getChildren().size() - 1)) {
            String value = parseHBox((HBox) children);
            if(!value.isEmpty()){
                result.add(value);
            } else {
                throw new IllegalArgumentException("unable to parse empty master");
            }
        }
        if(result.isEmpty()){
            throw new IllegalArgumentException("empty list");
        }
        return result;
    }

    private static String parseHBox(HBox hBox){
        TextField textField =  (TextField) hBox.getChildren().get(0);
        return textField.getText();
    }
}
