 import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int n = scanner.nextInt();
        
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];
        
        // Take input
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ":");
            
            while (true) {
                System.out.print("Enter weight (kg): ");
                weight[i] = scanner.nextDouble();
                if (weight[i] > 0) break;
                System.out.println("Please enter positive value.");
            }
            
            while (true) {
                System.out.print("Enter height (m): ");
                height[i] = scanner.nextDouble();
                if (height[i] > 0) break;
                System.out.println("Please enter positive value.");
            }
        }
        
        // Calculate BMI and status
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);
            
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        
        // Display results
        System.out.println("\n=== BMI Report ===");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d - Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s%n",
                i + 1, height[i], weight[i], bmi[i], status[i]);
        }
        
        scanner.close();
    }
}