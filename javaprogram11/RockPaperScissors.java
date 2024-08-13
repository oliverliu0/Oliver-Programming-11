import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        //Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        //Display the game instructions
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Type 'r' for rock, 'p' for paper, or 's' for scissors:");

        //Read the user's choice
        String userInput = scanner.nextLine().toLowerCase();

        //  Validate user input
        if (!userInput.equals("r") && !userInput.equals("p") && !userInput.equals("s")) {
            System.out.println("Invalid input. Please enter 'r', 'p', or 's'.");
            return;
        }

        //Generate a random choice for the computer
        Random random = new Random();
        int computerChoice = random.nextInt(3); // 0 for rock, 1 for paper, 2 for scissors

        String computerInput;
        if (computerChoice == 0) {
            computerInput = "r";
        } else if (computerChoice == 1) {
            computerInput = "p";
        } else {
            computerInput = "s";
        }

        //Display the choices
        System.out.println("\nPlayer: " + convertChoice(userInput) + " VS Computer: " + convertChoice(computerInput));

        // Determine the winner
        if (userInput.equals(computerInput)) {
            System.out.println("It's a tie!");
        } else if ((userInput.equals("r") && computerInput.equals("s")) ||
                (userInput.equals("p") && computerInput.equals("r")) ||
                ( userInput.equals("s") && computerInput.equals("p"))) {
            System.out.println("You Win!");
        } else {
            System.out.println("You Lose!");

        }




        //Close the scanner
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

