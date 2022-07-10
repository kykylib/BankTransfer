
import WorkService.*;


public class Main {
    public static void main(String[] args) throws ValidationException {

        Account account1 = Account.addAccount("Svetlana", "Lib", "UA12345");
        Account account2 = Account.addAccount("Nika", "Liberman", "UA54321");

        while(true) {
            Terminal.StartProgram();
        }



    }
}
