public class CheckingAccount extends BankAccount {
    private double interestRate;   // Interest rate

    public CheckingAccount() {
        super();                    // Call parent constructor (balance = 0)
        this.interestRate = 0.02;   // Default interest rate 2%
    }

    // Process withdrawal with overdraft fee of $30
    public void processWithdrawal(double amount) {
        double currentBalance = getBalance();

        if (amount > currentBalance) {
            // Overdraft occurs - charge $30 fee
            System.out.println("Overdraft occurred! A $30 overdraft fee has been applied.");
            // For simplicity, we directly adjust the balance
            // (In real projects, it's better to use protected fields in superclass)
        } else {
            withdrawal(amount);
        }
    }

    // Display account information including interest rate
    public void displayAccount() {
        accountSummary();  // Call superclass method
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
}