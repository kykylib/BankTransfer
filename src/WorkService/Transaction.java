package WorkService;


import java.time.LocalDate;

public class Transaction {
    private String firstName;
    private String lastName;
    private String nameOfAccount;
    private int money;
    private String status;
    private final LocalDate date;

    Transaction(String firstName,String lastName,int money,String nameOfAccount){
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
        this.nameOfAccount = nameOfAccount;
        this.date = LocalDate.now();
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getNameOfAccount(){
        return nameOfAccount;
    }

    public int getMoney(){
        return money;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String string){
        status = string;
    }


    public LocalDate getDataTime(){
        return date;
    }

    public static Transaction addTransaction(String firstName,String lastName,int money,String nameOfAccount){
      final   Transaction transaction = new Transaction(firstName,lastName,money,nameOfAccount);
      transaction.setStatus("ok");
        return transaction;
    }

}
