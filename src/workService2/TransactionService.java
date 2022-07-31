package workService2;

public class TransactionService {

    private AccountDAO accountD;
    private String nameOfAccount;

    public TransactionService(AccountDAO accountDAO,String nameOfAcc){
        accountD = accountDAO;
        nameOfAccount = nameOfAcc;
    }

    public void processTransaction(Transaction transaction) throws TransactionServiceException {
        if (accountD.getAccountByAccountId(nameOfAccount).getAccountName().equals(nameOfAccount) && accountD.getAccountByAccountId(nameOfAccount).getStatus() == null) {
            return;
        }
        if (accountD.getAccountByAccountId(nameOfAccount).getStatus() != null) {
            transaction.setStatus(Constans.STATUS_FAIL);
            accountD.getAccountByAccountId(nameOfAccount).addTransactionToAccountHistory(transaction);
            throw new TransactionServiceException("Failed to complete transaction. Account is blocked");
        }
        transaction.setStatus(Constans.STATUS_FAIL);
        throw new TransactionServiceException("Account not founded");

    }

}
