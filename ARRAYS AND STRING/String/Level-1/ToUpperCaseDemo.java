import java.util.Scanner;

public class ToUpperCaseDemo {
    
    // Method to convert to uppercase using charAt()
    public static String toUpperCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }
    
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
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Convert using custom method
        String customUpper = toUpperCase(text);
        
        // Convert using built-in method
        String builtInUpper = text.toUpperCase();
        
        // Compare the two strings
        boolean areEqual = compareStrings(customUpper, builtInUpper);
        
        // Display results
        System.out.println("\nCustom toUpperCase(): " + customUpper);
        System.out.println("Built-in toUpperCase(): " + builtInUpper);
        System.out.println("Strings are equal: " + areEqual);
        
        scanner.close();
    }
}