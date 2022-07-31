
import workService2.*;


public class Main {
    public static void main(String[] args)  {
        AccountDAO accountDAO = new AccountDAOImpl();
        Terminal terminal = new Terminal(accountDAO);
        while (true){
            terminal.startProgram();
        }
    }
}
