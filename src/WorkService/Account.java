package WorkService;

public class Account {
    private Transaction [] historyOfTransaction = new Transaction[1000];
    private String firstName;
    private String lastName;
    private String accountName;
    private String status;
    private int totalMoney;

    Account(String firstName, String lastName, String accountName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountName = accountName;
        this.status = "not blocked";
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAccountName(){
        return accountName;
    }

    public String getStatus(){
        return status;
    }

    public int getTotalMoney(){
        return totalMoney;
    }

    public String setStatus(String string){
        status = string;
        return status;
    }



    public static Account addAccount(String firstName, String lastName, String accountName){
        Account account = new Account(firstName,lastName,accountName);
        Bank.addAccountToDatabase(account);
        return account;
    }

    public static void addTransactionToAccount(Account account, Transaction transaction){
        account.totalMoney += transaction.getMoney();
        for(int i = 0; i<i+1;i++) {
            if(account.historyOfTransaction[i] == null) {
                account.historyOfTransaction[i] = transaction;
                break;
            }
        }
    }

    public static void getAccountHistoryOfTransaction(Account account){
        for(int i = 0; i<account.historyOfTransaction.length;i++) {
            if(account.historyOfTransaction[i] != null) {
                System.out.println("FirstName: " + account.historyOfTransaction[i].getFirstName() + " || LastName: " + account.historyOfTransaction[i].getLastName() + " || Money Transferred: " + account.historyOfTransaction[i].getMoney() + " || Status: " + account.historyOfTransaction[i].getStatus() + " || Time: " + account.historyOfTransaction[i].getDataTime() + "\n");
            }
            if(account.historyOfTransaction[0] == null){
                System.out.println("Account history is clear");
                break;
            }
        }
    }

//    public Transaction getHistoryOfTransaction(int i){
//        return historyOfTransaction[i];
//    }


}
