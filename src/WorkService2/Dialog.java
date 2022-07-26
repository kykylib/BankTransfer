package WorkService2;

public class Dialog {
    public static void startTheDialog(){
        System.out.println("Who are you?");
    }

    public static void getChoice(){
        System.out.println("1 - Client" + "\n" + "2 - Customs");
    }

    public static void enterFirstName(){
        System.out.println("Enter first name");
    }

    public static void enterLastName(){
        System.out.println("Enter last name");
    }

    public static void enterAmountOfMoney(){
        System.out.println("enter amount of money");
    }

    public static void enterTargetBankAccount(){
        System.out.println("enter target bank account number");
    }

    public static void enterBankAccount(){
        System.out.println("enter bank account number");
    }

    public  static void printErrorMessage(Exception ex){
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }
}
