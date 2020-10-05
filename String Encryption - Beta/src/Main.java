import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String message;
        int wordOne = 0;
        int wordTwo = 0;
        int wordThree = 0;
        int wordFour = 0;
        int wordFive = 0;
        int wordSix = 0;
        int wordSeven = 0;
        int wordEight = 0;
        int wordNine = 0;
        int wordTen = 0;
        Scanner scan = new Scanner(System.in);

        message = scan.next();
        for(int i = 0; i < message.length(); i++){
            if(message.charAt(i) != ' '){
                wordOne++;
            }
        }
        for(int i = wordOne; i < message.length(); i++){
            if(message.charAt(i) != ' '){
                wordTwo++;
            }
        }
        System.out.println(wordOne + " " + wordTwo);
        System.out.println(message);
    }
}
