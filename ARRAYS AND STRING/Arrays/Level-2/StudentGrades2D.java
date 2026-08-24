import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        
        double[][] marks = new double[n][3];
        double[] percentage = new double[n];
        String[] grade = new String[n];
        
        // Take input
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            
            String[] subjects = {"Physics", "Chemistry", "Maths"};
            for (int j = 0; j < 3; j++) {
                while (true) {
                    System.out.print("Enter " + subjects[j] + " marks: ");
                    marks[i][j] = scanner.nextDouble();
                    if (marks[i][j] >= 0) break;
                    System.out.println("Please enter positive value.");
                }
            }
        }
        
        // Calculate percentage and grade using 2D array
        for (int i = 0; i < n; i++) {
            double total = 0;
            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
            }
            percentage[i] = total / 3;
            
            if (percentage[i] >= 90) {
                grade[i] = "A";
            } else if (percentage[i] >= 80) {
                grade[i] = "B";
            } else if (percentage[i] >= 70) {
                grade[i] = "C";
            } else if (percentage[i] >= 60) {
                grade[i] = "D";
            } else if (percentage[i] >= 50) {
                grade[i] = "E";
            } else {
                grade[i] = "F";
            }
        }
        
        // Display results
        System.out.println("\n=== Grade Report ===");
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d - Physics: %.2f, Chemistry: %.2f, Maths: %.2f, Percentage: %.2f%%, Grade: %s%n",
                i + 1, marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }
        
        scanner.close();
    }
}