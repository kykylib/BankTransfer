package workService2;


public class AccountDAOImpl implements AccountDAO{

    private DatabaseOfAccounts database;

    public AccountDAOImpl(DatabaseOfAccounts database){
        this.database = database;
    }


    @Override
    public Account[] getAllAccount() {
        return database.accounts;
    }

    @Override
    public Account getAccountByAccountId(String id) {
        int numId=0;
        for(int i=0;i<database.accounts.length;i++){
            if (database.accounts[i]==null){
                break;
            }
            if(database.accounts[i].getAccountName().equals(id)){
                numId = i;
                break;
            }
        }
        return database.accounts[numId];
    }

}
