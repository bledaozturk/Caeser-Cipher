import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");
        String inputText = scanner.nextLine();
        
        System.out.print("Enter shift key (0-25): ");
        int shiftKey = scanner.nextInt();

        // Encrypt the input text using Caesar cipher
        String encrypted = encrypt(inputText, shiftKey);
        System.out.println("Encrypted text: " + encrypted);

        scanner.close(); // Close the scanner to free resources
    }

    // Caesar cipher encryption method
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                // Determine base character ('A' for uppercase, 'a' for lowercase)
                char base = Character.isUpperCase(c) ? 'A' : 'a';

                // Shift character within alphabet range
                char shifted = (char) ((c - base + shift) % 26 + base);
                result.append(shifted);
            } else {
                // Non-letter characters remain unchanged
                result.append(c);
            }
        }

        return result.toString();
    }
}
