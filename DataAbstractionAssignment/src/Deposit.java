import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    //Requires: we require double type amount, Date type data, and String type account
    //Modifies: this
    //Effects: we are going to create an instance of deposit class with user input information

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: we require none
    //Modifies: this
    //Effects: we return the deposit amount, date of the transaction, and account type.

    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
