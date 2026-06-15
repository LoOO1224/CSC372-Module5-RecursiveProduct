import java.util.Scanner;

public class RecursiveProduct {

    public static int calculateProduct(int[] numbers, int index) {
        if (index == numbers.length) {
            return 1;
        }

        return numbers[index] * calculateProduct(numbers, index + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Recursive Product Calculator");
        System.out.println("Please enter five numbers.");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        int product = calculateProduct(numbers, 0);

        System.out.println();
        System.out.println("The product of the five numbers is: " + product);

        input.close();
    }
}