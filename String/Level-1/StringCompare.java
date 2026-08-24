import java.util.Scanner;

public class StringCompare {
    
    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String str1 = scanner.next();
        
        System.out.print("Enter second string: ");
        String str2 = scanner.next();
        
        // Compare using custom method
        boolean customResult = compareStrings(str1, str2);
        
        // Compare using built-in method
        boolean builtInResult = str1.equals(str2);
        
        // Display results
        System.out.println("\nCustom charAt() comparison: " + customResult);
        System.out.println("Built-in equals() comparison: " + builtInResult);
        System.out.println("Results match: " + (customResult == builtInResult));
        
        scanner.close();
    }
}