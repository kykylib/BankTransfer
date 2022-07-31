package workService2;

public class SecurityService {

    private AccountDAO accountDAO;
    private Transaction transaction;
    private String accountName;

    public SecurityService(AccountDAO accountDAO1,Transaction transaction1, String accountName1){
        accountDAO = accountDAO1;
        transaction = transaction1;
        accountName = accountName1;
    }

    public void checkMoney() throws SecurityServiceException{
            if(transaction.getMoney()<100000 && accountDAO.getAccountByAccountId(accountName).getAccountName().equals(transaction.getNameOfAccount())){
                accountDAO.getAccountByAccountId(accountName).setTotalmoney(transaction.getMoney());
                accountDAO.getAccountByAccountId(accountName).addTransactionToAccountHistory(transaction);
                return;
            }
            if(transaction.getMoney()>99999 && accountDAO.getAccountByAccountId(accountName).getAccountName().equals(transaction.getNameOfAccount())){
                transaction.setStatus(Constans.STATUS_BLOCKED);
                accountDAO.getAccountByAccountId(accountName).addTransactionToAccountHistory(transaction);
                accountDAO.getAccountByAccountId(accountName).setStatus(Constans.STATUS_BLOCKED);
                throw new SecurityServiceException("Failed to complete transaction.");
            }
    }
}
