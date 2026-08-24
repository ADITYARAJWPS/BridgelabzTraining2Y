import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        
        // Take input with validation
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            
            // Get salary with validation
            while (true) {
                System.out.print("Enter salary: ");
                salary[i] = scanner.nextDouble();
                if (salary[i] > 0) break;
                System.out.println("Invalid salary. Please enter again.");
                i--;
                break;
            }
            
            // Get years of service with validation
            while (true) {
                System.out.print("Enter years of service: ");
                yearsOfService[i] = scanner.nextDouble();
                if (yearsOfService[i] >= 0) break;
                System.out.println("Invalid years of service. Please enter again.");
                i--;
                break;
            }
            
            totalOldSalary += salary[i];
        }
        
        // Calculate bonus
        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }
            
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalNewSalary += newSalary[i];
        }
        
        // Display results
        System.out.println("\n=== Bonus Report ===");
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        
        scanner.close();
    }
}