import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    
    // Method to generate IllegalArgumentException
    public static void generateException(String text) {
        System.out.println("Substring: " + text.substring(5, 2));
    }
    
    // Method to handle IllegalArgumentException
    public static void handleException(String text) {
        try {
            System.out.println("Substring: " + text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Generic exception caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.println("\n=== Generating IllegalArgumentException ===");
        try {
            generateException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\n=== Handling IllegalArgumentException ===");
        handleException(text);
        
        scanner.close();
    }
}