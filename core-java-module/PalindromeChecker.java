// PalindromeChecker.java
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Clean string: remove non-alphanumeric and convert to lowercase
        String cleanStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String reversed = new StringBuilder(cleanStr).reverse().toString();

        if (cleanStr.equals(reversed)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        sc.close();
    }
}
