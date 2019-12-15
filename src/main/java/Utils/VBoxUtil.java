package Utils;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VBoxUtil {
    public static void createVBox(ArrayList arrayList, VBox vbox){
        for(Object element: arrayList){
            HBox hBox = new HBox();
            Button button = new Button("-");
            button.setOnAction(e->vbox.getChildren().remove(hBox));
            hBox.getChildren().addAll(new TextField(element.toString()), button);
            vbox.getChildren().add(hBox);
        }
        Button addButton = new Button("add");
        addButton.setOnAction(e->{
            HBox hBox = new HBox();
            Button button = new Button("-");
            button.setOnAction(action->vbox.getChildren().remove(hBox));
            hBox.getChildren().addAll(new TextField(), button);
            vbox.getChildren().remove(addButton);
            vbox.getChildren().add(hBox);
            vbox.getChildren().add(addButton);
        });
        vbox.getChildren().add(addButton);
    }
}
