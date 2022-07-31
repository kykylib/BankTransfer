package workService2;

public class TransactionServiceException extends Exception{
    public TransactionServiceException(){}

    public TransactionServiceException(String message){
        super(message);
    }
}
