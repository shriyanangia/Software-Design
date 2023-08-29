/**
 * This class has 3 public methods
 *
 * @author snangia
 */
public class CheckingAccount extends Account
{
    private double overdraftLimit;  //withdrawals cannot exceed this limit

    public CheckingAccount(String accountHolder, int accountNumber, double accountBalance, double overdraftLimit)
    {
        super(accountHolder, accountNumber, accountBalance);
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * getter for overdraft limit
     * @return overdraft limit
     */
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * setter for overdraft limit
     * @param  overdraftLimit
     */
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }


    /**
     * method to withdraw money
     * amount withdrawn cannot exceed over draft limit otherwise an exception will be thrown
     * @param  amount to withdraw
     */
    public void withdraw(double amount)
    {
        if (accountBalance - amount >= -overdraftLimit)
        {
            accountBalance = accountBalance - amount;
        }
        else
        {
            throw new IllegalArgumentException("Overdraft limit will be exceeded");
        }
    }

}
