package WorkService;

public class Terminal {

    public static void StartProgram() {

            Dialog.startTheDialog();
            String answer = DataInput.stringDataInPut();
            if (answer.equals("Client")) {
                String firstName;
                String lastName;
                String nameAccount;
                int money;
                try {
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
                catch(ValidationException ex){
                        Dialog.printErrorMessage(ex);
                        return;
                    }


                Transaction transaction = Transaction.addTransaction(firstName, lastName, money, nameAccount);

                ValidationException.validationCheckAccount(nameAccount, transaction);

            }
            if (answer.equals("Customs")) {
                ValidationException.validationForTaxOffice();
            }
            else {
                System.out.println("Wry correctly" + "\n" + "try again");
            }
    }
}

