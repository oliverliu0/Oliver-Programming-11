import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Scanner object to read inputs

        // Create a customer with initial balances for checking and savings
        Customer customer = new Customer("John Doe", 123456, 500, 1000);

        // Introduction message
        System.out.println("Welcome to the Banking System, John Doe!");
        System.out.println("Your current balances are: ");
        System.out.println("Checking: $" + customer.getCheckBalance());
        System.out.println("Savings: $" + customer.getSavingBalance());

        boolean quit = false; //control whether the user wants to quit the system

        while (!quit) { // loop to process user actions
            // Menu options
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display all deposits");
            System.out.println("4. Display all withdrawals");
            System.out.println("5. Quit");

            if (scanner.hasNextInt()) { // Check whether the integer input is valid
                int option = scanner.nextInt();

                if (option == 1) {
                    // Deposit
                    System.out.println("You selected Deposit. Please choose the account:");
                    System.out.println("1. Checking");
                    System.out.println("2. Savings");

                    if (scanner.hasNextInt()) {
                        int depositAccountOption = scanner.nextInt();

                        // Handle invalid account selection
                        if (depositAccountOption != 1 && depositAccountOption != 2) {
                            System.out.println("Invalid account option.");
                            continue; // Skip the rest and go back to the menu
                        }

                        System.out.println("Enter the amount to deposit:"); // Get amount being deposited
                        if (scanner.hasNextDouble()) {
                            double depositAmount = scanner.nextDouble();
                            if (depositAccountOption == 1) { //deposits to checking account
                                customer.deposit(depositAmount, new Date(), Customer.CHECKING);
                                System.out.println("New Checking Balance: $" + customer.getCheckBalance());
                            } else if (depositAccountOption == 2) { // Deposits to savings account
                                customer.deposit(depositAmount, new Date(), Customer.SAVING);
                                System.out.println("New Savings Balance: $" + customer.getSavingBalance());
                            }
                        } else {
                            // Handles invalid deposit amount
                            System.out.println("Invalid deposit amount. Please enter a valid number.");
                            scanner.next(); // clear the invalid input
                        }
                    } else {
                        // Handles invalid account for deposits
                        System.out.println("Invalid account option. Please enter 1 or 2.");
                        scanner.next(); // clear the invalid input
                    }

                } else if (option == 2) {
                    // Withdraw
                    System.out.println("You selected Withdraw. Please choose the account:");
                    System.out.println("1. Checking");
                    System.out.println("2. Savings");

                    if (scanner.hasNextInt()) {
                        int withdrawAccountOption = scanner.nextInt();

                        // Handle invalid account selection
                        if (withdrawAccountOption != 1 && withdrawAccountOption != 2) {
                            System.out.println("Invalid account option.");
                            continue; // Skip the rest and go back to the menu
                        }

                        System.out.println("Enter the amount to withdraw:"); // Get the amount to withdraw
                        if (scanner.hasNextDouble()) {
                            double withdrawAmount = scanner.nextDouble();
                            // Withdraws from checking account
                            if (withdrawAccountOption == 1) {
                                double checkResult = customer.withdraw(withdrawAmount, new Date(), Customer.CHECKING);
                                if (checkResult > 0) {
                                    System.out.println("Withdrawal successful! New Checking Balance: $" + customer.getCheckBalance());
                                } else {
                                    System.out.println("Withdrawal failed due to overdraft protection. Current Checking Balance: $" + customer.getCheckBalance());
                                }
                            } else if (withdrawAccountOption == 2) { // Withdraws from savings account
                                double savingResult = customer.withdraw(withdrawAmount, new Date(), Customer.SAVING);
                                if (savingResult > 0) {
                                    System.out.println("Withdrawal successful! New Savings Balance: $" + customer.getSavingBalance());
                                } else {
                                    System.out.println("Withdrawal failed due to overdraft protection. Current Savings Balance: $" + customer.getSavingBalance());
                                }
                            }
                        } else {
                            // Handles invalid withdraw amount
                            System.out.println("Invalid withdraw amount. Please enter a valid number.");
                            scanner.next(); // clear the invalid input
                        }
                    } else {
                        // Handles invalid account selection for withdrawal
                        System.out.println("Invalid account option. Please enter 1 or 2.");
                        scanner.next(); // clear the invalid input
                    }

                } else if (option == 3) {
                    // Display all deposits
                    System.out.println("\n--- Deposits ---");
                    customer.displayDeposits();

                } else if (option == 4) {
                    // Display all withdrawals
                    System.out.println("\n--- Withdrawals ---");
                    customer.displayWithdraws();

                } else if (option == 5) {
                    // Quit
                    quit = true;
                    System.out.println("Thank you for using the banking system. Goodbye!");

                } else {
                    // Handles invalid option selection on main menu
                    System.out.println("Invalid option. Please choose a valid option.");
                }
            } else {
                // Handles invalid input.
                System.out.println("Invalid option. Please enter a valid number.");
                scanner.next(); // clear the invalid input
            }
        }

        scanner.close();
    }
}
