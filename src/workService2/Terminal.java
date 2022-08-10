package workService2;

public class Terminal {

    private final AccountDAO accountDAO;
    private final VerificationService verificationService;
    private Transaction transaction;
    private TransactionService transactionService;
    private final SecurityService securityService;


    public Terminal(AccountDAO accountDAO, VerificationService verificationService, Transaction transaction, TransactionService transactionService, SecurityService securityService){
        this.accountDAO = accountDAO;
        this.verificationService = verificationService;
        this.transaction = transaction;
        this.transactionService = transactionService;
        this.securityService = securityService;
    }

    public void startProgram() {
        System.out.println(Dialog.startOfDialog);
        System.out.println(Dialog.choice);
        String answer = DataInput.stringDataInPut();
        String string = " ";
        if (isClientScenario(answer)) {
            String firstName = "";
            String lastName = "";
            String idAccount = "";
            int money = 0;
            try {
                System.out.println(Dialog.firstName);
                firstName = DataInput.stringDataInPut();
                verificationService.checksTheNames(firstName);
            }
            catch (DataInputException ex) {
                string = String.format("Invalid first name: %s",firstName);
                System.out.println(string);
                Dialog.printErrorMessage(ex);
                return;
            }
            try {
                System.out.println(Dialog.lastName);
                lastName = DataInput.stringDataInPut();
                verificationService.checksTheNames(lastName);
            }
            catch (DataInputException ex) {
                string = String.format("Invalid last name: %s",lastName);
                System.out.println(string);
                Dialog.printErrorMessage(ex);
                return;
            }
            try {
                System.out.println(Dialog.amountOfMoney);
                money = DataInput.intDataInPut();
                verificationService.checksTheMoney(money);
            }
            catch (DataInputException ex) {
                string = String.format("Invalid money: %d",money);
                System.out.println(string);
                Dialog.printErrorMessage(ex);
                return;
            }
            try {

                System.out.println(Dialog.targetBankAccount);
                idAccount = DataInput.stringDataInPut();
                verificationService.checksTheAccountName(idAccount);
            }
            catch (DataInputException ex) {
                string = String.format("Invalid name account: %s",idAccount);
                System.out.println(string);
                Dialog.printErrorMessage(ex);
                return;
            }

            transaction = new Transaction(firstName, lastName, money, idAccount);
            transactionService = new TransactionService(accountDAO, idAccount, securityService);

            try {
                transactionService.processTransaction(transaction);
                transaction.setStatus(Constans.STATUS_SUCCESS);
                string = String.format("First name: %s" + "\n" + "Last name: %s" + "\n" + "Money: %d" + "\n" + "Translate to account: %s" + "\n" + "Status: %s" + "\n" + "Time: " + transaction.getData(),transaction.getFirstName(),transaction.getLastName(),transaction.getMoney(),transaction.getNameOfAccount(),transaction.getStatus());
                System.out.println(string);

            }
            catch (TransactionServiceException ex) {
                Dialog.printErrorMessage(ex);
                return;
            }
            catch (SecurityServiceException ex) {
                Dialog.printErrorMessage(ex);
                return;
            }
            return;
        }
        if (isCustomsScenario(answer)) {
            System.out.println(Dialog.bankAccount);
            String answerCustoms = DataInput.stringDataInPut();
            if (accountDAO.getAccountByAccountId(answerCustoms).getAccountName().equals(answerCustoms)) {
                string = String.format("First name: %s" + "\n" + "Last name: %s" + "\n" + "Status: %s" + "\n" + "Total money: %d" + "\n" + "Bank account name: %s" + "\n",accountDAO.getAccountByAccountId(answerCustoms).getFirstName(),accountDAO.getAccountByAccountId(answerCustoms).getLastName(),accountDAO.getAccountByAccountId(answerCustoms).getStatus(),accountDAO.getAccountByAccountId(answerCustoms).getTotalMoney(),accountDAO.getAccountByAccountId(answerCustoms).getAccountName());
                System.out.println(string);
                accountDAO.getAccountByAccountId(answerCustoms).showHistoryOfAccount();
                return;
            }
            else{
                System.out.println(Dialog.search);
            }
        } else {
            System.out.println(Dialog.letter);
        }
    }
    private boolean isCustomsScenario(String answer){return answer.equals("2");}
    private boolean isClientScenario(String answer){return answer.equals("1");}
}
