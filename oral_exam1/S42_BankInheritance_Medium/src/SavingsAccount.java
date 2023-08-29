/**
 * This class has 4 public methods
 *
 * @author snangia
 */

public class SavingsAccount extends Account {

    private double savingsInterestRate; //interest gained on amount in savings account

    public SavingsAccount(String accountHolder, int accountNumber, double accountBalance, double savingsInterestRate) {
        super(accountHolder, accountNumber, accountBalance);
        this.savingsInterestRate = savingsInterestRate;
    }

    /**
     * getter for interest rate
     * @return interest rate
     */
    public double getSavingsInterestRate() {
        return savingsInterestRate;
    }
    /**
     * setter for interest rate
     * @param  savingsInterestRate
     */
    public void setSavingsInterestRate(double savingsInterestRate) {
        this.savingsInterestRate = savingsInterestRate;
    }

    /**
     * method to withdraw money from savings account
     * exception thrown if withdrawal causes accountBalance to decrease below $0.00
     * @param  amount
     */
    public void withdraw(double amount) {
        if (accountBalance - amount >= 0) {
            accountBalance = accountBalance - amount;
        }
        else {
            throw new IllegalArgumentException("Account balance cannot be < 0.0");
        }
    }

    /**
     * method to update accountBalance after interest gained on savings has been added
     * no parameters
     */
    public void addInterest() {
        double interest = accountBalance * (savingsInterestRate / 100);
        accountBalance += interest;
    }
}