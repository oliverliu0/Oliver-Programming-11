import java.util.Scanner;

public class StringEncryption {

    // Method to encrypt the input text
    public static String encrypt(String text) {

        String[] words = text.split(" "); // Split the text into word
        StringBuilder encryptedText = new StringBuilder(); // String dText = "";

        // Iterate through each word
        for (String word : words) {
            if (word.length() > 1) {
                // Move the last letter to the front and add "ay" to the end
                String encryptedWord = word.charAt(word.length() - 1) + word.substring(0, word.length() - 1) + "ay";
                encryptedText.append(encryptedWord).append(" ");
            } else {
                // For single letter words, just add "ay" to the end
                encryptedText.append(word).append("ay ");
            }
        }

        // Return the final encrypted string, and trim the extra spaces
        return encryptedText.toString().trim();
    }

    // Method to decrypt the encrypted text
    public static String decrypt(String text) {
        String[] words = text.split(" "); // Split the text into words
        StringBuilder decryptedText = new StringBuilder(); // String dText = "";

        // Iterate through each word
        for (String word : words) {   // Hello -> oHellay -> "Hello " ,  There => eTheray => There
            //           012345   -> " Hello There "
            // Remove "ay" from the end and move the first letter to the end
            String decryptedWord = word.substring(1, word.length() - 2) + word.charAt(0);
            decryptedText.append(decryptedWord).append(" ");
        }

        // Return the final decrypted string, trimming any extra space
        return decryptedText.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner object for user input

        // Prompt the user to enter text for encryption
        System.out.println("Enter the text to be encrypted:");
        String originalText = scanner.nextLine();

        // Encrypt the user's input and display the encrypted text
        String encryptedText = encrypt(originalText);
        System.out.println("Encrypted text: " + encryptedText);

        // Decrypt the encrypted text and display the decrypted (original) text
        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close(); // Close the scanner
    }
}
