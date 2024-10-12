//import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;

    //Requires: We need an instance of customer class
    //Modifies: this (nothing will be changed)
    //Effects: Return current balance of chequing account as a double type
    public double getCheckBalance() {
        return checkBalance;
    }
    //Requires: We need an instance of customer class
    //Modifies: this (nothing will be changed)
    //Effects: Return current balance of savings account as a double type
    public double getSavingBalance() {
        return savingBalance;
    }

    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    //Requires: none
    //Modifies: this
    //Effects: create an instance of customer class with default value

    Customer(){
        //create default constructor
        this.name = "";
        this.accountNumber = 0;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
        this.checkBalance = 0;
        this.savingBalance = 0;
    }
    //Requires: a string type for name, integer type for account number, double type for cheque deposit, double type for saving deposit
    //Modifies: this
    //Effects: create an instance of customer class with user inputed value
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
    }

    // Method for deposit
    //Requires: we require a double type deposit amount, Date type date, string type for account
    //Modifies: this
    //Effects: we are going to add transaction record to deposits arraylist. If the account type matches with either chequing or saving
    //         if nothing matches, we do nothing
    public double deposit(double amt, Date date, String account) {
        if (amt <= 0) {
            System.out.println("Deposit amount must be positive.");
            return 0;  // Negative or zero deposits are not allowed
        }

        if (account.equals(CHECKING)) {
            checkBalance += amt;
            deposits.add(new Deposit(amt, date, CHECKING));
            System.out.println("Deposit of: $" + amt + " Date: " + date + " into account: " + CHECKING);
        } else if (account.equals(SAVING)) {
            savingBalance += amt;
            deposits.add(new Deposit(amt, date, SAVING));
            System.out.println("Deposit of: $" + amt + " Date: " + date + " into account: " + SAVING);
        } else {
            System.out.println("Invalid account type.");
            return 0; // Invalid account type should return 0
        }

        return amt; // Return the deposit amount
    }

    // Method for withdraw
    //Requires: we require a double type withdraw amount, Date type date, string type for account
    //Modifies: this
    //Effects: we are going to add withdraw record to withdraw arraylist. If the account type matches with either chequing or saving 
    //         and doesn't overdraft. If nothing matches, we do nothing
    public double withdraw(double amt, Date date, String account) {
        if (amt <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return 0;  // Negative or zero withdrawals are not allowed
        }

        if (account.equals(CHECKING)) {
            if (checkOverdraft(amt, CHECKING)) {
                checkBalance -= amt;
                withdraws.add(new Withdraw(amt, date, CHECKING));
                System.out.println("Withdraw of: $" + amt + " Date: " + date + " from account: " + CHECKING);
                return amt;
            } else {
                System.out.println("Overdraft! Cannot withdraw from checking.");
                return 0;  // Return 0 if withdrawal exceeds overdraft limit
            }
        } else if (account.equals(SAVING)) {
            if (checkOverdraft(amt, SAVING)) {
                savingBalance -= amt;
                withdraws.add(new Withdraw(amt, date, SAVING));
                System.out.println("Withdraw of: $" + amt + " Date: " + date + " from account: " + SAVING);
                return amt;
            } else {
                System.out.println("Overdraft! Cannot withdraw from savings.");
                return 0;  // Return 0 if withdrawal exceeds overdraft limit
            }
        } else {
            System.out.println("Invalid account type.");
            return 0; // Invalid account type should return 0
        }
    }
    //Requires: we require a double type withdraw amount, string type for account
    //Modifies: this
    //Effects: we are going to check whether the user is overdrafting. If so, we are going to return true; if not, we return false. 
    private boolean checkOverdraft(double amt, String account) {
        if (account.equals(CHECKING)) {
            // Checking if the withdrawal exceeds the current balance plus overdraft limit
            return (checkBalance - amt >= OVERDRAFT);
        } else if (account.equals(SAVING)) {
            // Checking if the withdrawal exceeds the savings balance plus overdraft limit
            return (savingBalance - amt >= OVERDRAFT);
        }
        return false; // Invalid account type, treat it as an overdraft failure
    }
    //Requires: we require none
    //Modifies: this
    //Effects: we are going to print out all the deposit history in the deposit array list 
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //Requires: we require none
    //Modifies: this
    //Effects: we are going to print out all the withdraw history in the withdraw array list 
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
