import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsLoop {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int YourScore = 0;
        int ComputerScore = 0;

        // Loop to allow multiple rounds of the game
        while (playAgain) {
            // Display the game instructions
            System.out.println("Let's play Rock, Paper, Scissors!");
            System.out.println("Type 'r' for rock, 'p' for paper, or 's' for scissors:");
            System.out.println("Type 'q' to quit the game.");

            // Read the user's choice
            String userInput = scanner.nextLine().toLowerCase();

            // Check if the user wants to quit
            if (userInput.equals("q")) {
                System.out.println("\nThanks for playing! Goodbye.");
                break;
            }

            // Validate user input
            if (!userInput.equals("r") && !userInput.equals("p") && !userInput.equals("s")) {
                System.out.println("\nInvalid input. Please enter 'r', 'p', 's', or 'q' to quit.");
                System.out.println();
                continue;
            }

            // Generate a random choice for the computer
            int computerChoice = random.nextInt(3); // 0 for rock, 1 for paper, 2 for scissors

            // Convert computer's choice to a string
            String computerInput;
            if (computerChoice == 0) {
                computerInput = "r";
            } else if (computerChoice == 1) {
                computerInput = "p";
            } else {
                computerInput = "s";
            }

            // Display the choices
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("\nPlayer: " + convertChoice(userInput) + " VS Computer: " + convertChoice(computerInput));

            // Determine the winner and update score
            if (userInput.equals(computerInput)) {
                System.out.println("\t\t\t\tIt's a tie!");
            } else if ((userInput.equals("r") && computerInput.equals("s")) ||
                    (userInput.equals("p") && computerInput.equals("r")) ||
                    (userInput.equals("s") && computerInput.equals("p"))) {
                System.out.println("\t\t\t\tYou Win!");
                YourScore++;
            } else {
                System.out.println("\t\t\t\tYou Lose!");
                ComputerScore++;

            }
            // Display the current scores
            System.out.println("\t\t\nPlayer Score: " + YourScore + "\t\tComputer Score: " + ComputerScore);
            System.out.println("\n------------------------------------------------------------------------------------"); // Add an extra line for better readability

        }



        // Close the scanner
        scanner.close();
    }

    // Method to convert choice from 'r', 'p', 's' to the full string
    public static String convertChoice(String choice) {
        switch (choice) {
            case "r":
                return "Rock";
            case "p":
                return "Paper";
            case "s":
                return "Scissors";
            default:
                return "Invalid choice";
        }
    }
}


