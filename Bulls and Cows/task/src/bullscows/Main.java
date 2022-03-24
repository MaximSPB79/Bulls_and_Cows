package bullscows;

import java.util.Scanner;

public class Main {

    private static int bull = 0;
    private static int cow = 0;
    private static int lengthNumber;
    private static String strNumberOfDigits;
    protected static int numberCharacters;
    protected static int numberOfDigits;


    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        SecretNumber secretNumber = new SecretNumber();
        final char quotationMark = '"';
        int countTurn = 1;
        System.out.println("Please, enter the secret code's length:");
        strNumberOfDigits = scanner.nextLine();
        String[] strNumberOfDigitsPart = strNumberOfDigits.split("");

        if (strNumberOfDigitsPart.length > 2) {
            System.out.println("Error: " + quotationMark + strNumberOfDigits + quotationMark + " isn't a valid number.");
            return;
        } else {
            numberOfDigits = Integer.parseInt(strNumberOfDigits);
        }
        if (numberOfDigits < 1 || numberOfDigits > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        } else {
            System.out.println("Input the number of possible symbols in the code:");
            numberCharacters = scanner.nextInt();
        }
        if (numberCharacters < 1 || numberCharacters > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }
        if (secretNumber.exceptionHandling()) {
            return;
        } else {
            secretNumber.creatingASecretCode();
            while (true) {
                bull = 0;
                cow = 0;
                System.out.println("Turn " + countTurn++ + ":");
                strokeProcessing(secretNumber);
                if (bull == lengthNumber) {
                    break;
                }
            }
            System.out.println("Congratulations! You guessed the secret code.");
        }
    }


    static void strokeProcessing(SecretNumber secretNumber) {
        Scanner scanner = new Scanner(System.in);
        String strNumber = scanner.nextLine();
        String codInput = String.valueOf(secretNumber.getResult());
        String[] secretCode = codInput.split("");
        String[] number = strNumber.split("");
        lengthNumber = number.length;
        //System.out.println(codInput);// ***************
        for (int i = 0; i < lengthNumber; i++) {
            if (secretCode[i].equals(number[i])) {
                bull++;
            }
        }
        for (int i = 0; i < lengthNumber; i++) {
            for (int j = 0; j < lengthNumber; j++) {
                if (number[i].equals(secretCode[j])) {
                    cow++;
                }
            }
        }
        cow -= bull;
        if ((bull == 0 && cow == 0) ||
                (bull > 0 && cow > 0)) {
            System.out.printf("Grade: %d cow(s) and %d bull(s). \n", cow, bull);
        } else if (bull > 0) {
            if (bull > 1) {
                System.out.printf("Grade: %d bulls. \n", bull);
            } else {
                System.out.printf("Grade: %d bull. \n", bull);
            }
        } else if (cow > 0) {
            if (cow > 1) {
                System.out.printf("Grade: %d cows. \n", cow);
            } else {
                System.out.printf("Grade: %d cow. \n", cow);
            }
        } else {
            System.out.printf("Grade: %d bulls and %d cows. \n", bull, cow);
        }
    }
}