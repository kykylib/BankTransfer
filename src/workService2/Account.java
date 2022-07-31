package workService2;


public class Account {
    private Transaction[] historyOfTransaction = new Transaction[10];
    private final String firstName;
    private final String lastName;
    private final String accountName;
    private String status;
    private int totalMoney;

    Account(String firstName, String lastName, String accountName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountName = accountName;
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

    public void setTotalmoney(int sum){
        this.totalMoney += sum;
    }

    public String setStatus(String string){
        status = string;
        return status;
    }

    public void addTransactionToAccountHistory(Transaction transaction){
        for(int i=0;i<historyOfTransaction.length;i++){
           if(historyOfTransaction[i]==null){
                historyOfTransaction[i] = transaction;
                break;
           }
        }
    }

    public void showHistoryOfAccount(){
        for(int i=0;i<historyOfTransaction.length;i++){
            if(historyOfTransaction[i]!=null){
                System.out.println("Transaction - " + (i+1)  + "\n" + "First name: " + historyOfTransaction[i].getFirstName() + "\n" + "Last name: " + historyOfTransaction[i].getLastName() + "\n" + "Money: " + historyOfTransaction[i].getMoney() + "\n" + "Status: " + historyOfTransaction[i].getStatus() + "\n" + "Time: " + historyOfTransaction[i].getData() + "\n");
            }
            if(historyOfTransaction[0]==null){
                System.out.println("Account history is clear");
                break;
            }
        }

    }
}
