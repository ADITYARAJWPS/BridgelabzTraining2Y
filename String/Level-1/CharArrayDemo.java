 import java.util.Scanner;

public class CharArrayDemo {
    
    // Method to return characters without using toCharArray()
    public static char[] getChars(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }
    
    // Method to compare two char arrays
    public static boolean compareArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        // Get chars using custom method
        char[] customChars = getChars(text);
        
        // Get chars using built-in method
        char[] builtInChars = text.toCharArray();
        
        // Compare the two arrays
        boolean areEqual = compareArrays(customChars, builtInChars);
        
        // Display results
        System.out.println("\nCustom method result: " + new String(customChars));
        System.out.println("Built-in toCharArray(): " + new String(builtInChars));
        System.out.println("Arrays are equal: " + areEqual);
        
        scanner.close();
    }
}