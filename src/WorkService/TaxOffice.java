package WorkService;

public class TaxOffice {
    public static void showAccountHistoryForTaxTaxOffice() throws ValidationException {
        Dialog.enterBankAccount();
        String nameOfAccount = DataInput.stringDataInPut();
        for (int i = 0; i < i + 1; i++) {
            if (Bank.getDatabaseOfAccount(i).getAccountName().equals(nameOfAccount)) {
                Account account = Bank.getDatabaseOfAccount(i);
                Account.getAccountHistoryOfTransaction(account);
            }
            else {
                throw new ValidationException("not founded");
            }
            break;
        }
    }
}

