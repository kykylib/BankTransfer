package workService2;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationService {

    private static final String NAME_PATTERN="^[a-zA-Z]+$";
    private static final String ACCOUNT_PATTERN="^[U]{1}+[A]{1}+[1-9]{5,}+$";
    private static final Pattern pattern_name = Pattern.compile(NAME_PATTERN);
    private static final Pattern pattern_accountName = Pattern.compile(ACCOUNT_PATTERN);

    public String checksTheNames(String name) throws DataInputException {
        Matcher matcher = pattern_name.matcher(name);
        if (!matcher.find()) {
            throw new DataInputException("incorrectly name");
        }
        return name;
    }

    public int checksTheMoney(int money) throws DataInputException {
        if(money <= 0) {
            throw new DataInputException("incorrectly price");
        }
        return money;
    }

    public String checksTheAccountName(String account) throws DataInputException {
        Matcher matcher = pattern_accountName.matcher(account);
        if (!matcher.find()) {
            throw new DataInputException("incorrectly account");
        }
        return account;
    }
}
