package workService2;

public class Dialog {

    public static final String startTheDialog = "Who are you?";

    public static final String getChoice = "1 - Client" + "\n" + "2 - Customs";

    public static final String enterFirstName = "Enter first name";

    public static final String enterLastName = "Enter last name";

    public static final String enterAmountOfMoney = "enter amount of money";

    public static final String enterTargetBankAccount = "enter target bank account number";

    public static final String enterBankAccount = "enter bank account number";

    public static void printErrorMessage(Exception ex){
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }
}
