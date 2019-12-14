package WorkShops.AutoRepairShop;

import Interfaces.ParsableFromFile;
import WorkShops.AutoRepairShop.Master.Master;
import WorkShops.Workshop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

import static Functions.AutoRepairShopFunctions.parse;
import static Functions.AutoRepairShopFunctions.printArrayList;

public class AutoRepairShop extends Workshop  implements ParsableFromFile, Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<String> typeOfRepairingCars;
    private ArrayList<Master> masters;

    public AutoRepairShop(){
        super();
        typeOfRepairingCars = new ArrayList<>();
        masters = new ArrayList<>();
    }

    public void parseFromFile(String nameOfFile) throws IOException, ParseException {
        parse(nameOfFile,this);
    }

    public void writeToFile(String nameOfFile) throws IOException {
        FileWriter fileWriter = new FileWriter(nameOfFile);
        fileWriter.write(this.toString());
        fileWriter.close();
    }

    public void addTypeOfRepairingCar(String nameOfBrand) {
        typeOfRepairingCars.add(nameOfBrand);
    }

    @Override
    public void addMaster(Master master) {
        this.masters.add(master);
    }

    @Override
    public void setMasters(ArrayList<Master> masters) {
        this.masters = masters;
    }

    public void setTypeOfRepairingCars(ArrayList<String> typeOfRepairingCars) {
        this.typeOfRepairingCars = typeOfRepairingCars;
    }

    @Override
    public String toString(){
        StringBuilder data = new StringBuilder();
        data.append(super.toString())
                .append(printArrayList(typeOfRepairingCars)).append("\n")
                .append(printArrayList(masters)).append("\n");
        return data.toString();
    }
}
