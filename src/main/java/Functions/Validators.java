package Functions;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {

    public static boolean validateNumber(String number) throws IllegalArgumentException{
        Pattern pattern = Pattern.compile("(((\\+?375|80)(29|33|44))[0-9]{7})|(80(17|21|22|23|16|15)[0-9]{7})");
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }
}
