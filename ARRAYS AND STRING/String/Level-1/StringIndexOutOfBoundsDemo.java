import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    
    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {
        System.out.println("Character at index 100: " + text.charAt(100));
    }
    
    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String text) {
        try {
            System.out.println("Character at index 100: " + text.charAt(100));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Generic exception caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.println("\n=== Generating StringIndexOutOfBoundsException ===");
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\n=== Handling StringIndexOutOfBoundsException ===");
        handleException(text);
        
        scanner.close();
    }
}