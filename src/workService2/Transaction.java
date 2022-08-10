package workService2;

import java.time.LocalDate;

public class Transaction {
    private String firstName;
    private String lastName;
    private String nameOfAccount;
    private int money;
    private String status;
    private LocalDate date = null;

    public Transaction(String firstName, String lastName, int money, String nameOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
        this.nameOfAccount = nameOfAccount;
        this.date = LocalDate.now();
    }
    public Transaction() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNameOfAccount() {
        return nameOfAccount;
    }

    public int getMoney() {
        return money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String string) {
        status = string;
    }

    public LocalDate getData() {
        return date;
    }

}
