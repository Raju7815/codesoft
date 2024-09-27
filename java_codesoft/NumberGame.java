import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.print("Enter the number of rounds you want to play: ");
        int rounds = scanner.nextInt();
        int totalScore = 0;

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            final int maxAttempts = 10;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (1-100): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("Too low!");
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number.");
                    totalScore += maxAttempts - attempts + 1;
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all your attempts. The number was " + number + ".");
            }
        }

        System.out.println("\nGame Over! Your total score is " + totalScore + ".");
        scanner.close();
    }
}
