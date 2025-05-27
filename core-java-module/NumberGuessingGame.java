
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
        Scanner scanner = new Scanner(System.in);
        int userGuess = 0;

        System.out.println("Guess the number between 1 and 100:");

        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Correct! You guessed the number.");
            }
        }

        scanner.close();
    }
}
