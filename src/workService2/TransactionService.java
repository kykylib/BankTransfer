package workService2;

public class TransactionService {

    private AccountDAO accountDAO;
    private String nameOfAccount;
    private SecurityService securityService;


    public TransactionService(AccountDAO accountDAO, String nameOfAccount, SecurityService securityService) {
        this.accountDAO = accountDAO;
        this.nameOfAccount = nameOfAccount;
        this.securityService = securityService;
    }

    public TransactionService() {
    }


    public void processTransaction(Transaction transaction) throws TransactionServiceException, SecurityServiceException {
        if (accountExists() && isBlocked()) {
            securityService.checkMoney(accountDAO, transaction);
            return;
        }
        if (isBlocked() == false) {
            transaction.setStatus(Constans.STATUS_FAIL);
            accountDAO.getAccountByAccountId(nameOfAccount).addTransactionToAccountHistory(transaction);
            throw new TransactionServiceException("Failed to complete transaction. Account is blocked");
        }
        transaction.setStatus(Constans.STATUS_FAIL);
        throw new TransactionServiceException("Account not founded");
    }

    private boolean accountExists() {
        return accountDAO.getAccountByAccountId(nameOfAccount).getAccountName().equals(nameOfAccount);
    }

    private boolean isBlocked() {
        return accountDAO.getAccountByAccountId(nameOfAccount).getStatus() == null;
    }

}
