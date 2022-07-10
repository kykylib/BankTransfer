package WorkService;

public class ValidationException extends Exception {
    public ValidationException() {

    }

    public ValidationException(String message) {
        super(message);
    }


    public static void validationCheckAccount(String nameOfAccount,Transaction transaction){
        try{
            Bank.checkAccount(nameOfAccount,transaction);
        }
        catch (ValidationException ex4){
            System.out.println(ex4.getMessage());
        }
    }

    public static void validationCheckMoney(int i, Transaction transaction) {
        try {
            SecurityService.checkMoney(i,transaction);
        }
        catch (Exception ex5){
            System.out.println(ex5.getMessage());
        }
    }

    public static void validationForTaxOffice(){
        try {
            TaxOffice.showAccountHistoryForTaxTaxOffice();
        }
        catch (Exception ex6){
            System.out.println(ex6.getMessage());
        }
    }
}
