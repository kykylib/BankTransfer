package WorkService2;

public class Terminal {
    public static void startProgram(AccountDAO accountDAO){
        Dialog.startTheDialog();
        Dialog.getChoice();
        String answer = DataInput.stringDataInPut();
        if(answer.equals("1")){
            String firstName = "";
            String lastName = "";
            String nameAccount = "";
            int money = 0;
            try{
                Dialog.enterFirstName();
                firstName = DataInput.stringDataInPut();
                VerificationService.verificatingNames(firstName);
                Dialog.enterLastName();
                lastName = DataInput.stringDataInPut();
                VerificationService.verificatingNames(lastName);
                Dialog.enterAmountOfMoney();
                money = DataInput.intDataInPut();
                VerificationService.verificatingAmountOfMoney(money);
                Dialog.enterTargetBankAccount();
                nameAccount = DataInput.stringDataInPut();
                VerificationService.verificatingBankAccount(nameAccount);
            }
            catch (DataInputException ex){
                Dialog.printErrorMessage(ex);
                return;
            }

            Transaction transaction = new Transaction(firstName,lastName,money,nameAccount);

            try {
                BankService.checkAccount(accountDAO,nameAccount,transaction);
                SecurityService.checkMoney(accountDAO,transaction);
                System.out.println("First name: " + transaction.getFirstName() + "\n" + "Last name: " + transaction.getLastName() + "\n" +  "Money: " + transaction.getMoney() + "\n" +  "Translate to account: " +  transaction.getNameOfAccount() + "\n" +  "Status: " +  transaction.getStatus() + "\n");

            }
            catch (BankServiceException ex){
                Dialog.printErrorMessage(ex);
                return;
            }
            catch (SecurityServiceException ex){
                Dialog.printErrorMessage(ex);
                return;
            }
            return;
        }

        if(answer.equals("2")){
            Dialog.enterBankAccount();
            String answerCustoms = DataInput.stringDataInPut();
            for (int i =0;i<accountDAO.getAllAccount().length;i++) {
                if (answerCustoms.equals(accountDAO.getAccount(i).getAccountName())){
                    System.out.println("First name: " + accountDAO.getAccount(i).getFirstName() + "\n" + "Last name: " + accountDAO.getAccount(i).getLastName() + "\n" + "Total money: " + accountDAO.getAccount(i).getTotalMoney() + "\n" + "Bank account name: " + accountDAO.getAccount(i).getAccountName() + "\n");
                    accountDAO.getAccount(i).getHistoryOfAccount();
                    break;
                }
            }
            return;
        }
        else{
            System.out.println("write correctly" + "\n" + "Try again");
        }

    }
}
