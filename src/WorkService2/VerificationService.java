package WorkService2;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationService {
    public static String verificatingNames(String name) throws DataInputException {

        String stringPattern = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(name);

        if (matcher.find() == true) {
        }
        else {
            throw new DataInputException("incorrectly name");
        }
        return name;
    }

    public static int verificatingAmountOfMoney(int money) throws DataInputException {
        if (money > 0) {
        }
        else {
            throw new DataInputException("incorrectly price");
        }
        return money;
    }

    public static String verificatingBankAccount(String account) throws DataInputException {

        String stringPattern = "^[UA]+[1-9]{5,}+$";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(account);

        if (matcher.find() == true) {
        }
        else {
            throw new DataInputException("incorrectly account");
        }
        return account;
    }
}
