import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message;
        String encryption;

        message = scan.next();
        char finalChar = message.charAt(message.length() - 1);
        encryption = finalChar + message.substring(0, message.length() -1) + "ay";
        System.out.println(encryption);

        System.out.println(encryption.substring(1, encryption.length() -2) + finalChar);
    }
}
