// HashMapExample.java
import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Enter student ID and name pairs (type 'done' to finish):");
        while (true) {
            System.out.print("Enter student ID: ");
            if (!sc.hasNextInt()) break;
            int id = sc.nextInt();
            sc.nextLine();  // consume newline
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            studentMap.put(id, name);
        }

        System.out.print("Enter student ID to search: ");
        int searchId = sc.nextInt();

        String studentName = studentMap.get(searchId);
        if (studentName != null) {
            System.out.println("Student name: " + studentName);
        } else {
            System.out.println("Student ID not found.");
        }

        sc.close();
    }
}
