package workService2;

public class SecurityService {

    public SecurityService(){}

    public void checkMoney(AccountDAO accountDAO,Transaction transaction) throws SecurityServiceException{
            if(transaction.getMoney()<100000){
                accountDAO.getAccountByAccountId(transaction.getNameOfAccount()).setTotalmoney(transaction.getMoney());
                accountDAO.getAccountByAccountId(transaction.getNameOfAccount()).addTransactionToAccountHistory(transaction);
                return;
            }
            if(transaction.getMoney()>99999){
                transaction.setStatus(Constans.STATUS_BLOCKED);
                accountDAO.getAccountByAccountId(transaction.getNameOfAccount()).addTransactionToAccountHistory(transaction);
                accountDAO.getAccountByAccountId(transaction.getNameOfAccount()).setStatus(Constans.STATUS_BLOCKED);
                throw new SecurityServiceException("Failed to complete transaction.");
            }
    }
}
