package WorkService;

public class Bank {
    private static Account [] databaseOfAccount = new Account[1000];
    private static Transaction [] databaseOfFailTransaction = new Transaction[1000];

    public static Account getDatabaseOfAccount(int i){
        return databaseOfAccount[i];
    }

    public static void addAccountToDatabase(Account account){
        for (int i = 0; i<i+1;i++){
            if(Bank.databaseOfAccount[i] == null){
                Bank.databaseOfAccount[i] = account;
                break;
            }
        }
    }

    public static void checkAccount(String nameOfAccount,Transaction transaction) throws ValidationException{
        for(int i = 0; i<i+1;i++){
            if(Bank.getDatabaseOfAccount(i).getAccountName().equals(nameOfAccount) && Bank.getDatabaseOfAccount(i).getStatus().equals("not blocked")){
                ValidationException.validationCheckMoney(i,transaction);
                break;
            }
            if(Bank.getDatabaseOfAccount(i).getAccountName().equals(nameOfAccount) && Bank.getDatabaseOfAccount(i).getStatus() == null){
                Bank.addTransactionToFailDataBase(transaction);
                transaction.setStatus("fail");
                Account account = getDatabaseOfAccount(i);
                Account.addTransactionToAccount(account,transaction);
                throw new ValidationException("blocked");
            }
            else{
                Bank.addTransactionToFailDataBase(transaction);
                transaction.setStatus("fail");
                throw new ValidationException("not funded");
            }
        }
    }

    public static Transaction getDatabaseOfFailTransaction(int i){
        return databaseOfFailTransaction[i];
    }

    public static void addTransactionToFailDataBase(Transaction transaction){
        for (int i = 0; i<i+1;i++){
            if(Bank.databaseOfFailTransaction[i] == null){
                Bank.databaseOfFailTransaction[i] = transaction;
                break;
            }
        }
    }




}
