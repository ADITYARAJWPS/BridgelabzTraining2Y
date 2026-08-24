import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int n = scanner.nextInt();
        
        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];
        
        // Take input
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ":");
            
            while (true) {
                System.out.print("Enter weight (kg): ");
                personData[i][0] = scanner.nextDouble();
                if (personData[i][0] > 0) break;
                System.out.println("Please enter positive value.");
            }
            
            while (true) {
                System.out.print("Enter height (m): ");
                personData[i][1] = scanner.nextDouble();
                if (personData[i][1] > 0) break;
                System.out.println("Please enter positive value.");
            }
        }
        
        // Calculate BMI and status
        for (int i = 0; i < n; i++) {
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        // Display results
        System.out.println("\n=== BMI Report ===");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d - Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s%n",
                i + 1, personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
        
        scanner.close();
    }
}