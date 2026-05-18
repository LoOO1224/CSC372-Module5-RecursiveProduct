import java.util.Scanner;

public class FloatingPointLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double total = 0.0;
        double max = -999999.0;
        double min = 999999.0;
        int count = 0;
        double number;

        // 정확히 5개의 부동소수점 숫자 입력받기
        while (count < 5) {
            System.out.print("Enter floating-point number " + (count + 1) + ": ");
            number = input.nextDouble();
            
            total += number;
            
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
            
            count++;
        }
        
        double average = total / 5;
        double interest = total * 0.20;

        // 결과 출력
        System.out.println("\nResults:");
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
        System.out.println("Interest on total at 20%: " + interest);
        
        input.close();
    }
}