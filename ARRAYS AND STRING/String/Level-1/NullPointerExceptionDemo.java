public class NullPointerExceptionDemo {
    
    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;
        System.out.println("Length: " + text.length());
    }
    
    // Method to handle NullPointerException
    public static void handleException() {
        String text = null;
        try {
            System.out.println("Length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Generating NullPointerException ===");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\n=== Handling NullPointerException ===");
        handleException();
    }
}