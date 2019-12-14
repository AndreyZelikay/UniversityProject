package WorkShops;

import WorkShops.AutoRepairShop.Master.Master;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static Functions.AutoRepairShopFunctions.printArrayList;

public abstract class Workshop implements Serializable {

    private String name;
    private ArrayList<String> telephoneNumbers;
    private String address;
    private Date openingDate;

    public Workshop(){
        telephoneNumbers = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public String getOpeningDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        return dateFormat.format(openingDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephoneNumbers(ArrayList<String> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public void addTelephoneNumber(String number){
        telephoneNumbers.add(number);
    }

    public void setOpeningDate(Date date) {
        this.openingDate = date;
    }

    public abstract void setMasters(ArrayList<Master> masters);

    public abstract void addMaster(Master master);

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        data.append(name).append("\n")
                .append(printArrayList(telephoneNumbers)).append("\n")
                .append(address).append("\n")
                .append((openingDate != null) ? dateFormat.format(openingDate) : "Opening date hasn't inputted yet").append("\n");
        return data.toString();
    }
}
