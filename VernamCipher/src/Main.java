import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input text: ");
        String text = reader.readLine();

        char[] Text = text.toCharArray();
        char[] Key = new char[Text.length];
        char[] Encrypted = new char[Text.length];
        char[] Decrypted = new char[Text.length];

        Key = GeneratedKey(Text, Key);
        Encrypted = Encrypt(Text, Key, Encrypted);
        Decrypted = Decrypt(Key, Encrypted, Decrypted);

        System.out.println("Text: " + String.valueOf(Text));
        System.out.println("Key: " + String.valueOf(Key));
        System.out.println("Encrypted: " + String.valueOf(Encrypted));
        System.out.println("Decrypted: " + String.valueOf(Decrypted));
    }

    public static char[] GeneratedKey(char[] Text, char[] Key) {
        Random random = new Random();
        for (int i = 0; i < Text.length; i++) {
            Key[i] = (char) random.nextInt(Character.MAX_VALUE);
        }
        return Key;
    }

    public static char[] Encrypt(char[] Text, char[] Key, char[] Encrypted) {
        for (int i = 0; i < Text.length; i++) {
            Encrypted[i] = (char) (Text[i] ^ Key[i]);
        }
        return Encrypted;
    }

    public static char[] Decrypt(char[] Key, char[] Encrypted, char[] Decrypted) {
        for (int i = 0; i < Key.length; i++) {
            Decrypted[i] = (char) (Encrypted[i] ^ Key[i]);
        }
        return Decrypted;
    }
}