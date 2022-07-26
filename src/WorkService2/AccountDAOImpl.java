package WorkService2;


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
    public Account getAccount(int num) {
        return database.accounts[num];
    }

}
