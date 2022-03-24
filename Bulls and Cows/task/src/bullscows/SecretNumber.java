package bullscows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static bullscows.Main.numberCharacters;
import static bullscows.Main.numberOfDigits;

public class SecretNumber {

    private StringBuilder result;
    private final List<Character> listChar = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'));

    private List<Character> randomListChar = new ArrayList<>();

    public void creatingASecretCode() {

        System.out.print("The secret is prepared: ");
        printStar(numberOfDigits);
        if (numberCharacters > 10) {
            System.out.println(" (0-9, a-" + listChar.get(numberCharacters - 1) + ").");
        } else if (numberCharacters <= 10) {
            System.out.println(" (0-" + listChar.get(numberCharacters - 1) + ").");
        }
        System.out.println("Okay, let's start a game!");
        generation();
    }


    public boolean exceptionHandling() {
        if (numberOfDigits > numberCharacters) {
            System.out.println("Error: it's not possible to generate a code with a length of " + numberOfDigits +
                    " with " + numberCharacters + " unique symbols.");
            return true;
        } else {
            return false;
        }
    }

    private void printStar(int numberOfDigits) {
        for (int i = 0; i < numberOfDigits; i++) {
            System.out.print("*");
        }
    }

    private void generation() {

        for (var ch : listChar.subList(0, numberOfDigits)) {
            randomListChar.add(ch);
        }
        Collections.shuffle(randomListChar);
        result = new StringBuilder();
        for (var character : randomListChar) {
            result.append(character);
        }
    }

    public StringBuilder getResult() {
        return result;
    }
}

