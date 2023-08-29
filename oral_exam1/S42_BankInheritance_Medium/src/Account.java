/**
 * This class has 6 public methods
 *
 * @author snangia
 */

public class Account extends Object
{
    protected final String accountHolder;   //name of account owner
    protected final int accountNumber;  //account number
    protected double accountBalance;    //current amount in bank account

    public Account(String accountHolder, int accountNumber, double accountBalance)
    {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    /**
     * getter for account owner
     * @return name of account holder
     */
    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * getter for account number
     * @return number of account
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * getter for account balance
     * @return account balance
     */
    public double getAccountBalance() {
        return accountBalance;
    }
    /**
     * setter for account number
     * @param accountBalance
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }


    /**
     * method for depositing money into account
     * @param  amount to deposit
     */
    public void deposit(double amount)
    {
        accountBalance += amount;
    }


    /**
     *
     * @return String representation of Account object
     */
    @Override // indicates that this method overrides a superclass method
    public String toString()
    {
        return String.format("Account holder: %s,Account number: %s, \t Balance:  $%.2f",
                getAccountHolder(), getAccountNumber(), getAccountBalance());
    }
}
