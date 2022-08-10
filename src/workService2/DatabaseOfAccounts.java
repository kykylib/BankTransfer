package workService2;

public class DatabaseOfAccounts {
    public Account [] accounts;


    public DatabaseOfAccounts(){
        accounts = new Account[1000];
        Account account1 = new Account("Svetlana","Liberman","UA12345");
        Account account2 = new Account("Nik","Lib","UA54321");
        addAccountToDataBase(account1);
        addAccountToDataBase(account2);
    }

    public void addAccountToDataBase(Account account){
        for(int i=0; i<accounts.length;i++){
            if(accounts[i] == null){
                accounts[i]=account;
                break;
            }
        }
    }
}
