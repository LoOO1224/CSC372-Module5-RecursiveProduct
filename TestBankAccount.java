public class TestBankAccount {
    public static void main(String[] args) {
        System.out.println("===== BankAccount Test =====");
        BankAccount account1 = new BankAccount();
        account1.setFirstName("John");
        account1.setLastName("Doe");
        account1.setAccountID(1001);
        account1.deposit(500.0);
        account1.withdrawal(200.0);
        account1.accountSummary();

        System.out.println("\n===== CheckingAccount Test =====");
        CheckingAccount checking = new CheckingAccount();
        checking.setFirstName("Jane");
        checking.setLastName("Smith");
        checking.setAccountID(2002);
        checking.deposit(1000.0);
        checking.processWithdrawal(1200.0);   // Overdraft test
        checking.displayAccount();
    }
}