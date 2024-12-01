import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Game!");
        System.out.print("Enter the number of rounds you want to play: ");
        int rounds = scanner.nextInt();
        int totalScore = 0;

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);
            int randomNumber = random.nextInt(100) + 1; // Generate a number between 1 and 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I have picked a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1; // Higher score for fewer attempts
                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all " + maxAttempts + " attempts. The correct number was " + randomNumber + ".");
            }
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
