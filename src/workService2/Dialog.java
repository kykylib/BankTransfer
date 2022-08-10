package workService2;

public class Dialog {

    public static final String startOfDialog = "Who are you?";

    public static final String choice = "1 - Client" + "\n" + "2 - Customs";

    public static final String firstName = "Enter first name";

    public static final String lastName = "Enter last name";

    public static final String amountOfMoney = "enter amount of money";

    public static final String targetBankAccount = "enter target bank account number";

    public static final String bankAccount = "enter bank account number";

    public static final String search = "Not founded";

    public static final String letter = "write correctly" + "\n" + "Try again";

    public static void printErrorMessage(Exception ex){
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }
}
