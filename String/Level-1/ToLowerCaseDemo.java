import java.util.Scanner;

public class ToLowerCaseDemo {
    
    // Method to convert to lowercase using charAt()
    public static String toLowerCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
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
                return false;
            if (str1.charAt(i) != str2.charAt(i)) {
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Convert using custom method
        String customLower = toLowerCase(text);
        
        // Convert using built-in method
        String builtInLower = text.toLowerCase();
        
        // Compare the two strings
        boolean areEqual = compareStrings(customLower, builtInLower);
        
        // Display results
        System.out.println("\nCustom toLowerCase(): " + customLower);
        System.out.println("Built-in toLowerCase(): " + builtInLower);
        System.out.println("Strings are equal: " + areEqual);
        
        scanner.close();
    }
}