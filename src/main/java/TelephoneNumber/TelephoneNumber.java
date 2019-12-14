package TelephoneNumber;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneNumber implements Serializable {

    private String number;
    private TypeOfTelephoneNumber typeOfTelephoneNumber;

    public TelephoneNumber(){}

    public TelephoneNumber(String number) throws IllegalArgumentException{
        parseNumber(number);
    }

    private void parseNumber(String number) throws IllegalArgumentException{
        Pattern pattern = Pattern.compile("(((\\+?375|80)(29|33|44))[0-9]{7})|(80(17|21|22|23|16|15)[0-9]{7})");
        Matcher matcher = pattern.matcher(number);
        if(matcher.find()){
            this.number = number;
            if(matcher.group(5) == null){
                typeOfTelephoneNumber = TypeOfTelephoneNumber.Mobile;
            } else{
                typeOfTelephoneNumber = TypeOfTelephoneNumber.Home;
            }

        } else{
            throw new IllegalArgumentException("Wrong number!");
        }
    }

    @Override
    public String toString(){
        StringBuilder telephone = new StringBuilder();
        telephone.append(number).append(" ")
                 .append(typeOfTelephoneNumber);
        return telephone.toString();
    }
}
