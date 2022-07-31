package workService2;

public class Terminal {

    AccountDAO accountDAO;

    public Terminal(AccountDAO accountDao){
        accountDAO = accountDao;
    }

    public void startProgram() {
        System.out.println(Dialog.startTheDialog);
        System.out.println(Dialog.getChoice);
        String answer = DataInput.stringDataInPut();
        if (answer.equals("1")) {
            String firstName = "";
            String lastName = "";
            String nameAccount = "";
            int money = 0;
            VerificationService verificationService = new VerificationService();
            try {
                System.out.println(Dialog.enterFirstName);
                firstName = DataInput.stringDataInPut();
                verificationService.checksTheNames(firstName);
            }
            catch (DataInputException ex) {
                System.out.println("Invalid first name: " + firstName);
                Dialog.printErrorMessage(ex);
                return;
            }
            try {
                System.out.println(Dialog.enterLastName);
                lastName = DataInput.stringDataInPut();
                verificationService.checksTheNames(lastName);
            }
            catch (DataInputException ex) {
                System.out.println("Invalid last name: " + lastName);
                Dialog.printErrorMessage(ex);
                return;
            }
            try {
                System.out.println(Dialog.enterAmountOfMoney);
                money = DataInput.intDataInPut();
                verificationService.checksTheMoney(money);
            }
            catch (DataInputException ex) {
                System.out.println("Invalid money: " + money);
                Dialog.printErrorMessage(ex);
                return;
            }
            try {

                System.out.println(Dialog.enterTargetBankAccount);
                nameAccount = DataInput.stringDataInPut();
                verificationService.checksTheAccountName(nameAccount);
            }
            catch (DataInputException ex) {
                System.out.println("Invalid name account:" + nameAccount);
                Dialog.printErrorMessage(ex);
                return;
            }

            Transaction transaction = new Transaction(firstName, lastName, money, nameAccount);
            TransactionService transactionService = new TransactionService(accountDAO, nameAccount);
            SecurityService securityService = new SecurityService(accountDAO,transaction,nameAccount);

            try {
                transactionService.processTransaction(transaction);
                securityService.checkMoney();
                transaction.setStatus(Constans.STATUS_SUCCESS);
                System.out.println("First name: " + transaction.getFirstName() + "\n" + "Last name: " + transaction.getLastName() + "\n" + "Money: " + transaction.getMoney() + "\n" + "Translate to account: " + transaction.getNameOfAccount() + "\n" + "Status: " + transaction.getStatus() + "\n" + "Time: " + transaction.getData() + "\n");

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
        if (answer.equals("2")) {
            System.out.println(Dialog.enterBankAccount);
            String answerCustoms = DataInput.stringDataInPut();
            if (accountDAO.getAccountByAccountId(answerCustoms).getAccountName().equals(answerCustoms)) {
                System.out.println("First name: " + accountDAO.getAccountByAccountId(answerCustoms).getFirstName() + "\n" + "Last name: " + accountDAO.getAccountByAccountId(answerCustoms).getLastName() + "\n" + "Total money: " + accountDAO.getAccountByAccountId(answerCustoms).getTotalMoney() + "\n" + "Bank account name: " + accountDAO.getAccountByAccountId(answerCustoms).getAccountName() + "\n");
                accountDAO.getAccountByAccountId(answerCustoms).showHistoryOfAccount();
                return;
            }
            else{
                System.out.println("Not founded");
            }
        } else {
            System.out.println("write correctly" + "\n" + "Try again");
        }

    }
}
