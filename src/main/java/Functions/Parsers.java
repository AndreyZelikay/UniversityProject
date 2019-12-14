package Functions;

import WorkShops.AutoRepairShop.AutoRepairShop;
import WorkShops.WorkShopList;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
