package workService2;


public class AccountDAOImpl implements AccountDAO{

    private DatabaseOfAccounts database;

    public AccountDAOImpl(){
        database = new DatabaseOfAccounts();
        Account account1 = new Account("Svetlana","Liberman","UA12345");
        Account account2 = new Account("Nik","Lib","UA54321");
        database.addAccountToDataBase(account1);
        database.addAccountToDataBase(account2);
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
