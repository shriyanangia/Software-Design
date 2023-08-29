
/**
 * Main driver class to test different functionality included in the accounts
 * Allows banker to to use the banking system
 * @author snangia
 */

public class Bank
{
    /**
     * This method will automatically be called when Bank is run.
     *
     * @param args Command line arguments.
     */

    public static void main(String[] args)
    {
        //creating a new savings account
        SavingsAccount accountSavings = new SavingsAccount("megan",123457895,1034.55,1.0);
        System.out.printf("%s %s%n", "Account holder is: ", accountSavings.getAccountHolder());
        System.out.printf("%s %s%n", "Account number is", accountSavings.getAccountNumber());
        //withdrawing money from account
        accountSavings.withdraw(60.45);
        //outputting account balance to test getAccountBalance method
        System.out.printf("%s %.2f%n", "Account balance is: ", accountSavings.getAccountBalance());
        //adding interest gained on savings to the accountBalance
        accountSavings.addInterest();
        System.out.println(accountSavings.toString());

        //creating a new loan account
        LoanAccount accountLoan = new LoanAccount("Construction22", 678456380, 1000.99,550.0, 1.0);
        //adding interest gained on loan
        accountLoan.chargeInterest();
        System.out.println(accountLoan.toString());
        //depositing money to loan account to reduce amount left to pay
        accountLoan.deposit(600.50);
        System.out.println(accountLoan.toString());

        //creating a new checking account
        CheckingAccount accountChecking2 = new CheckingAccount("lOra",457890356, 760.0,10);
        accountChecking2.withdraw(700.0);
        System.out.println(accountChecking2.toString());

        //creating a new checking account
        CheckingAccount accountChecking = new CheckingAccount("JayHoldings",459056567, 135600.60,50);
        System.out.printf("%s %s%n", "Account holder is: ", accountChecking.getAccountHolder());
        System.out.printf("%s %s%n", "Account number is", accountChecking.getAccountNumber());
        //withdrawal of this amount should give an exception error since it would exceed the overdraft limit
        accountChecking.withdraw(136600.90);

    }
}
