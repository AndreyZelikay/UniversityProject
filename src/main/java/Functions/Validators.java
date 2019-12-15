package Functions;

import DAO.UserDaoImpl;
import Models.User;
import Utils.MD5Util;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {

    public static boolean validateNumber(String number) throws IllegalArgumentException{
        Pattern pattern = Pattern.compile("(((\\+?375|80)(29|33|44))[0-9]{7}$)|(80(17|21|22|23|16|15)[0-9]{7}$)");
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }

    public static boolean validateUser(String name, String password){
        UserDaoImpl userDao = new UserDaoImpl();
        try{
            userDao.findByNameAndPassword(name, MD5Util.encrypt(password));
            return true;
        } catch (NoResultException e){
            return false;
        }
    }

    public static boolean validatePassword(String password){
        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=^.{6,}$)");
        Matcher matcher = pattern.matcher(password);
        return matcher.find() && password.length() < 20;
    }
}
