/**
 * This class has 6 public methods
 *
 * @author snangia
 */

public class LoanAccount extends Account
{
    private double currentBalance;  //loan balance to pay
    private double loanInterestRate;    //interest rate on the loan's currentBalance

    public LoanAccount(String accountHolder, int accountNumber, double accountBalance, double currentBalance, double loanInterestRate)
    {
        super(accountHolder, accountNumber, accountBalance);
        this.currentBalance = currentBalance;
        this.loanInterestRate = loanInterestRate;
    }


    /**
     * set current balance
     * @param  currentBalance
     */
    public void setCurrentBalance(double currentBalance) {
        if (currentBalance < 0.0) {
            throw new IllegalArgumentException("Current balance should be >= 0.0");
        }
        this.currentBalance = currentBalance;
    }

    /**
     * getter for current balance
     * @return current balance
     */
    public double getCurrentBalance() {return currentBalance;}

    /**
     * getter for loan interest rate
     * @return loan interest rate
     */
    public double getLoanInterestRate() {
        return loanInterestRate;
    }

    /**
     * setter for loan interest rate
     * @param  loanInterestRate
     */
    public void setLoanInterestRate(double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    /**
     * interest added to loan amount to give current balance
     */
    public void chargeInterest()
    {
        currentBalance +=  (currentBalance * (loanInterestRate/100));
    }

    /**
     * when money is deposited to pay off loan
     * remaining currentBalance decreases
     * since money is paid from account, overall accountBalance decreases
     * @param  amount
     */
    @Override
    public void deposit(double amount)
    {
        accountBalance = accountBalance - amount;
        currentBalance = currentBalance - amount;
    }


}
