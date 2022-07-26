package WorkService2;

public class DatabaseOfAccounts {
    public Account [] accounts;

    public DatabaseOfAccounts(){
        accounts = new Account[1000];
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
