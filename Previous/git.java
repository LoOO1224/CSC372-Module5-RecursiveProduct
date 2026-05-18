import java.util.Scanner;

public class git init {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your weekly income: $");
        double income = scanner.nextDouble();
        
        double taxRate;
        
        if (income < 500) {
            taxRate = 0.10;
        } else if (income >= 500 && income < 1500) {
            taxRate = 0.15;
        } else if (income >= 1500 && income < 2500) {
            taxRate = 0.20;
        } else {
            taxRate = 0.30;
        }
        
        double taxAmount = income * taxRate;
        
        System.out.printf("Weekly Income: $%.2f%n", income);
        System.out.printf("Tax Rate: %.0f%%%n", taxRate * 100);
        System.out.printf("Weekly Tax Withholding: $%.2f%n", taxAmount);
        System.out.printf("Average Weekly Withholding: $%.2f%n", taxAmount);
        
        scanner.close();
    }
}