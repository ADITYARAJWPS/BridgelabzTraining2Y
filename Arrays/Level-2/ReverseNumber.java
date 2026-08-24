import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        // Count digits
        long temp = number;
        int count = 0;
        while (temp != 0) {
            count++;
            temp /= 10;
        }
        
        // Store digits
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = (int)(number % 10);
            number /= 10;
        }
        
        // Create reverse array
        int[] reverse = new int[count];
        for (int i = 0; i < count; i++) {
            reverse[i] = digits[count - 1 - i];
        }
        
        // Display in reverse order
        System.out.println("Number in reverse order:");
        for (int i = 0; i < count; i++) {
            System.out.print(reverse[i]);
        }
        System.out.println();
        
        scanner.close();
    }
}