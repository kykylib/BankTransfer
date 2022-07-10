package WorkService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationService {

    public static String verificatingNames(String name) throws ValidationException{

        String stringPattern = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(name);

        if (matcher.find() == true) {
            System.out.println("correct name");
        }
        else {
            throw new ValidationException("incorrectly name");
        }
        return name;
    }

    public static int verificatingAmountOfMoney(int money) throws ValidationException{
        if (money > 0) {
            System.out.println("correct price");
        }
        else {
            throw new ValidationException("incorrectly price");
        }
        return money;
    }

    public static String verificatingBankAccount(String account) throws ValidationException{

        String stringPattern = "^[UA]+[1-9]{5,}+$";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(account);

        if (matcher.find() == true) {
        }
        else {
            throw new ValidationException("incorrectly account");
        }
        return account;
    }
}
