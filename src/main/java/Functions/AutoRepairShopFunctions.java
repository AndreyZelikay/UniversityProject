package Functions;

import WorkShops.AutoRepairShop.AutoRepairShop;
import WorkShops.AutoRepairShop.Master.Master;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class AutoRepairShopFunctions {

    public static String printArrayList(ArrayList arrayList){
        StringBuilder result = new StringBuilder();
        if(arrayList != null){
            for(Object element: arrayList){
                result.append(element).append(" ");
            }
            return result.toString();
        }
        return "no information";
    }

    public static void parse(String nameOfFile, AutoRepairShop repairShop) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(nameOfFile));
        String name = reader.readLine();
        ArrayList<String> numbers = parseNumbers(reader);
        String address = reader.readLine();

        repairShop.setName(name);
        repairShop.setAddress(address);
        repairShop.addTelephoneNumber(numbers.get(0));

        repairShop.setTelephoneNumbers(numbers);
        repairShop.setOpeningDate(Parsers.parseDate(reader.readLine()));
        repairShop.setTypeOfRepairingCars(parseTypesCars(reader));
        repairShop.setMasters(parseMasters(reader));
        reader.close();
    }

    private static ArrayList<Master> parseMasters(BufferedReader reader) throws IOException {
        ArrayList<Master> masters = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Master master = new Master(line);
            masters.add(master);
        }
        return masters;
    }

    private static ArrayList parseNumbers(BufferedReader reader) throws IOException {
        String[] stringNumbers = reader.readLine().split(" ");
        return new ArrayList<>(Arrays.asList(stringNumbers));
    }

    private static ArrayList parseTypesCars(BufferedReader reader) throws IOException {
        String[] stringCars = reader.readLine().split(" ");
        return new ArrayList<>(Arrays.asList(stringCars));
    }
}
