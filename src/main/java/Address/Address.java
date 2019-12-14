package Address;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

    private Integer numberOfHouse;
    private Integer housing;
    private String nameOfStreet;
    private Integer numberOfFlat;

    public Address(){}

    public Address(String address) {
       parseAddress(address);
    }

    private void parseAddress(String address){
        try {
            this.nameOfStreet = Functions.parseNameStreet(address);
            this.numberOfHouse = Functions.parseNumberHouse(address);
            this.numberOfFlat = Functions.parseNumberFlat(address);
            this.housing = Functions.parseHousing(address);
        } catch (IllegalArgumentException e){
            System.out.println("Wrong address");
        }
    }

    @Override
    public String toString(){
        StringBuilder address = new StringBuilder();
        address.append(nameOfStreet).append(" ")
                .append(numberOfHouse).append(" ")
                .append(Objects.requireNonNullElse(housing,"")).append(" ")
                .append(Objects.requireNonNullElse(numberOfFlat,"")).append(" ");
        return address.toString();
    }
}
