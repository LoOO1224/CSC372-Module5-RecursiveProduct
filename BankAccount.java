public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Constructor - initializes balance to zero
    public BankAccount() {
        this.balance = 0.0;
    }

    // Deposit method - adds the amount to the current balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdrawal method - subtracts the amount from the current balance
    public void withdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        }
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    // Prints all account information
    public void accountSummary() {
        System.out.println("===== Account Summary =====");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: $" + balance);
    }
}