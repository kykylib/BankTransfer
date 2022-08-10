
import workService2.*;


public class Main {
    public static void main(String[] args)  {
        DatabaseOfAccounts database = new DatabaseOfAccounts();
        AccountDAO accountDAO = new AccountDAOImpl(database);
        Transaction transaction = new Transaction();
        TransactionService transactionService = new TransactionService();
        VerificationService verificationService = new VerificationService();
        SecurityService securityService = new SecurityService();
        Terminal terminal = new Terminal(accountDAO,verificationService, transaction, transactionService, securityService);
        while (true){
            terminal.startProgram();
        }
    }
}
