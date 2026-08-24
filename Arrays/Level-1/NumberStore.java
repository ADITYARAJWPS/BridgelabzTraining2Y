
import java.util.Scanner;

public class NumberStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        // Infinite while loop
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double entry = scanner.nextDouble();
            
            // Break if 0 or negative
            if (entry <= 0) {
                break;
            }
            
            // Break if array is full
            if (index >= 10) {
                break;
            }
            
            // Store the number
            numbers[index] = entry;
            index++;
        }
        
        // Calculate total
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }
        
        // Display results
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("Total: " + total);
        
        scanner.close();
    }
}