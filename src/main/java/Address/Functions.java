package Address;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {

    private static String parse(String address, String regEx) throws IllegalArgumentException{
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(address);
        if(matcher.find()){
            return matcher.group(0);
        }
        throw new IllegalArgumentException();
    }

    static String parseNameStreet(String address) throws IllegalArgumentException{
        return parse(address, "ул\\..*?(\\s|$|/)").replaceAll("д\\.|\\s","");
    }

    static Integer parseNumberHouse(String address) throws IllegalArgumentException{
        return Integer.parseInt(parse(address, "д\\..*?(\\s|$|/)").replaceAll("д\\.|\\s|/",""));
    }

    static Integer parseNumberFlat(String address){
        try {
            return Integer.parseInt(parse(address, "кв\\..*?(\\s|$|/)").replaceAll("кв\\.|\\s", ""));
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    static Integer parseHousing(String address){
        try {
            return Integer.parseInt(parse(address, "д\\.[0-9]./.*?(\\s|$)").replaceAll("д\\.[0-9]./|\\s", ""));
        } catch (IllegalArgumentException e){
            return null;
        }
    }
}
