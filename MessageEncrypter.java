package Encrypter;

import java.util.Scanner;

public class MessageEncrypter {

    public static String encrypt(String message, int shift) {
        shift = shift % 26 + 26; // Normalize the shift value
        StringBuilder encrypted = new StringBuilder();
        for (char i : message.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encrypted.append((char) ('A' + (i - 'A' + shift) % 26));
                } else {
                    encrypted.append((char) ('a' + (i - 'a' + shift) % 26));
                }
            } else {
                encrypted.append(i);
            }
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a message to encrypt: ");
        String message = scanner.nextLine();

        System.out.println("Please enter a shift value: ");
        int shift = scanner.nextInt();

        String encryptedMessage = encrypt(message, shift);
        System.out.println("Encrypted Message: " + encryptedMessage);

        scanner.close();
    }
}
