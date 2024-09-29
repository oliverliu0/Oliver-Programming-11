import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TestCustomer {
    private Customer customer;

    @Before
    public void setUp() {
        // Create a customer with initial deposits
        customer = new Customer("John Doe", 123456, 500, 1000);
    }

    @Test
    public void testWithdrawCheckingWithOverdraft() {
        // Test valid withdrawal within the overdraft limit (Checking)
        double amount = 600;
        double result = customer.withdraw(amount, new Date(), Customer.CHECKING);
        assertEquals(600, result, 0); // Should allow withdraw, as 500 - 600 >= -100 (overdraft limit)
        assertEquals(-100, customer.getCheckBalance(), 0); // Balance should now be at -100

        // Test invalid withdrawal exceeding the overdraft limit (Checking)
        double overdraftResult = customer.withdraw(1, new Date(), Customer.CHECKING);
        assertEquals(0, overdraftResult, 0); // Should not allow withdraw, balance would go below -100
        assertEquals(-100, customer.getCheckBalance(), 0); // Balance should remain at -100
    }

    @Test
    public void testWithdrawSavingWithOverdraft() {
        // Test valid withdrawal within the overdraft limit (Saving)
        double amount = 1100;
        double result = customer.withdraw(amount, new Date(), Customer.SAVING);
        assertEquals(1100, result, 0); // Should allow withdraw, as 1000 - 1100 >= -100 (overdraft limit)
        assertEquals(-100, customer.getSavingBalance(), 0); // Balance should now be at -100

        // Test invalid withdrawal exceeding the overdraft limit (Saving)
        double overdraftResult = customer.withdraw(1, new Date(), Customer.SAVING);
        assertEquals(0, overdraftResult, 0); // Should not allow withdraw, balance would go below -100
        assertEquals(-100, customer.getSavingBalance(), 0); // Balance should remain at -100
    }

    @Test
    public void testWithdrawCheckingNoOverdraft() {
        // Test withdrawal that doesn't involve overdraft (valid case)
        double amount = 100;
        double result = customer.withdraw(amount, new Date(), Customer.CHECKING);
        assertEquals(100, result, 0); // Should allow withdraw
        assertEquals(400, customer.getCheckBalance(), 0); // Balance should be updated correctly
    }

    @Test
    public void testWithdrawSavingNoOverdraft() {
        // Test withdrawal that doesn't involve overdraft (valid case)
        double amount = 200;
        double result = customer.withdraw(amount, new Date(), Customer.SAVING);
        assertEquals(200, result, 0); // Should allow withdraw
        assertEquals(800, customer.getSavingBalance(), 0); // Balance should be updated correctly
    }

    @Test
    public void testInvalidDeposit() {
        // Test invalid deposit (negative amount)
        double amount = -100;
        double result = customer.deposit(amount, new Date(), Customer.CHECKING);
        assertEquals(0, result, 0); // Negative deposits should return 0

        // Test invalid account type
        double invalidResult = customer.deposit(100, new Date(), "Invalid Account");
        assertEquals(0, invalidResult, 0); // Invalid account type should return 0
    }

    @Test
    public void testDepositeChecking() {
        // Test valid withdraw from checking account
        double amount = 100;
        double result = customer.deposit(amount, new Date(), Customer.CHECKING);
        assertEquals(amount, result, 0);
        assertEquals(600, customer.getCheckBalance(), 0); // Check if the balance has been updated correctly
    }

    @Test
    public void testDepositeSaving() {
        // Test valid withdraw from saving account
        double amount = 200;
        double result = customer.deposit(amount, new Date(), Customer.SAVING);
        assertEquals(amount, result, 0);
        assertEquals(1200, customer.getSavingBalance(), 0); // Check updated savings balance
    }

    @Test
    public void testOverdraftProtectionChecking() {
        // Test overdraft protection on checking account
        double amount = 700;
        double result = customer.withdraw(amount, new Date(), Customer.CHECKING);
        assertEquals(0, result, 0); // Overdraft not allowed, should return 0
        assertEquals(500, customer.getCheckBalance(), 0); // Balance should remain unchanged
    }

    @Test
    public void testOverdraftProtectionSaving() {
        // Test overdraft protection on saving account
        double amount = 1500;
        double result = customer.withdraw(amount, new Date(), Customer.SAVING);
        assertEquals(0, result, 0); // Overdraft not allowed, should return 0
        assertEquals(1000, customer.getSavingBalance(), 0); // Balance should remain unchanged
    }

    @Test
    public void testInvalidWithdraw() {
        // Test invalid withdraw (negative amount)
        double amount = -100;
        double result = customer.withdraw(amount, new Date(), Customer.CHECKING);
        assertEquals(0, result, 0); // Negative withdraws should return 0

        // Test invalid account type
        double invalidResult = customer.withdraw(100, new Date(), "Invalid Account");
        assertEquals(0, invalidResult, 0); // Invalid account type should return 0
    }

}
