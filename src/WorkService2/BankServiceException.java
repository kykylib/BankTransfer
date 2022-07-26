package WorkService2;

public class BankServiceException extends Exception{
    public BankServiceException(){}

    public BankServiceException(String message){
        super(message);
    }
}
