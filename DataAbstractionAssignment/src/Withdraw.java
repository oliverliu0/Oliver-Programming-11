import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    //Requires: we require double type amount, Date type date, and String type account
    //Modifies: this
    //Effects: we create an instance of withdraw class with user input information

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    //Requires: we require none
    //Modifies: this
    //Effects: we return the withdraw amount, date of the transaction, and account type.
    public String toString(){
        //your code here
        return "Withdraw of: $" + amount + " Date: " + date + " from account: " + account;
    }
}
