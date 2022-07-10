package WorkService;

public class SecurityService {
    public static void checkMoney(int i, Transaction transaction) throws ValidationException {
            Account account = Bank.getDatabaseOfAccount(i);
            if (transaction.getMoney() < 100000) {
                transaction.setStatus("success");
                Account.addTransactionToAccount(account, transaction);
                System.out.println("Success || " + Bank.getDatabaseOfAccount(i).getAccountName() + " refill " + transaction.getMoney());
            } else {
                account.setStatus("blocked");
                transaction.setStatus("blocked");
                Account.addTransactionToAccount(account, transaction);
                throw new ValidationException("Failed to complete transactions");
            }
    }
}
