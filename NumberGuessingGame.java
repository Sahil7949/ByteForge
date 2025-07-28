import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int LOWER = 1;
        final int UPPER = 100;
        int target = random.nextInt(UPPER - LOWER + 1) + LOWER;
        int attempts = 0;
        int guess = -1;

        System.out.println("Welcome to the Unlimited Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + LOWER + " and " + UPPER + ".");
        System.out.println("Keep guessing until you get it right!");

        while (guess != target) {
            System.out.print("Enter your guess: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                scanner.next(); // skip invalid input
                continue;
            }
            guess = scanner.nextInt();
            attempts++;

            if (guess < LOWER || guess > UPPER) {
                System.out.println("Your guess should be between " + LOWER + " and " + UPPER + ".");
            } else if (guess < target) {
                System.out.println("Too low. Try again.");
            } else if (guess > target) {
                System.out.println("Too high. Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        }

        scanner.close();
    }
}

