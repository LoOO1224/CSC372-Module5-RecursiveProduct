import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceGUI extends JFrame implements ActionListener {

    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;

    public BankBalanceGUI() {
        account = new BankAccount();
        account.setFirstName("Wooyoung");
        account.setLastName("Cheon");
        account.setAccountID(358538);

        // Basic window settings
        setTitle("Bank Balance GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Title panel
        JLabel titleLabel = new JLabel("Bank Balance Application", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel);

        // Balance display panel
        JPanel displayPanel = new JPanel();
        balanceLabel = new JLabel("Balance: $0.00", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        displayPanel.add(balanceLabel);
        add(displayPanel);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Amount: $"));
        amountField = new JTextField(10);
        inputPanel.add(amountField);
        add(inputPanel);

        // Button panel
        JPanel buttonPanel = new JPanel();
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton showBtn = new JButton("Show Balance");

        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        showBtn.addActionListener(this);

        buttonPanel.add(depositBtn);
        buttonPanel.add(withdrawBtn);
        buttonPanel.add(showBtn);
        add(buttonPanel);

        setVisible(true);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {
            double amount = Double.parseDouble(amountField.getText());

            if (command.equals("Deposit")) {
                account.deposit(amount);
            } else if (command.equals("Withdraw")) {
                account.withdrawal(amount);
            }

            // Update balance display
            balanceLabel.setText("Balance: $" + String.format("%.2f", account.getBalance()));
            amountField.setText("");  // Clear input field

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    // Main method
    public static void main(String[] args) {
        new BankBalanceGUI();
    }
}