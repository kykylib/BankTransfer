package WorkService2;

public class SecurityService {
    public static void checkMoney(AccountDAO accountDAO,Transaction transaction) throws SecurityServiceException{
        for(int i =0;i<accountDAO.getAllAccount().length;i++){
            if(transaction.getMoney()<100000 && accountDAO.getAccount(i).getAccountName().equals(transaction.getNameOfAccount())){
                accountDAO.getAccount(i).setTotalmoney(transaction.getMoney());
                transaction.setStatus(Constans.STATUS_SUCCESS);
                accountDAO.getAccount(i).addTransactionToAccountHistory(transaction);
                break;
            }
            if(transaction.getMoney()>99999 && accountDAO.getAccount(i).getAccountName().equals(transaction.getNameOfAccount())){
                transaction.setStatus(Constans.STATUS_BLOCKED);
                accountDAO.getAccount(i).addTransactionToAccountHistory(transaction);
                accountDAO.getAccount(i).setStatus(Constans.STATUS_BLOCKED);
                throw new SecurityServiceException("Failed to complete transaction.");
            }
        }
    }
}
