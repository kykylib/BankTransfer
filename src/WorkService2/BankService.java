package WorkService2;

public class BankService {
    public static void checkAccount(AccountDAO accountDAO, String checkNameOfAccount, Transaction transaction) throws BankServiceException {
        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < accountDAO.getAllAccount().length; i++) {
                if (accountDAO.getAccount(i).getAccountName().equals(checkNameOfAccount) && accountDAO.getAccount(i).getStatus() == null) {
                    return;
                }
                if (accountDAO.getAccount(i).getAccountName().equals(checkNameOfAccount) && accountDAO.getAccount(i).getStatus() != null) {
                    transaction.setStatus(Constans.STATUS_FAIL);
                    accountDAO.getAccount(i).addTransactionToAccountHistory(transaction);
                    throw new BankServiceException("Failed to complete transaction. Account is blocked");
                }
            }
            transaction.setStatus(Constans.STATUS_FAIL);
            throw new BankServiceException("Account not founded");
        }
    }

}
