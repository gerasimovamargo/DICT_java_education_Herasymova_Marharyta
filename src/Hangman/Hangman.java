package Hangman;
import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon");


        String [] answers = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        int select = random.nextInt(answers.length);
        String correctAnswer = answers[select];

        char[] guessedLetters = new char[correctAnswer.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '-';
        }

        int remainingAttempts = 8;

        while (remainingAttempts > 0) {
            System.out.println("Guessed word: " + new String(guessedLetters));
            System.out.println("Attempts left: " + remainingAttempts);

            System.out.print("Input a letter: ");
            Scanner scanner = new Scanner(System.in);
            char inputLetter = scanner.nextLine().charAt(0);

            boolean letterGuessed = false;
            for (int i = 0; i < correctAnswer.length(); i++) {
                if (correctAnswer.charAt(i) == inputLetter) {
                    guessedLetters[i] = inputLetter;
                    letterGuessed = true;
                }
            }

            if (!letterGuessed) {
                System.out.println("That letter doesn't appear in the word");
                remainingAttempts--;
            }

            boolean allLettersGuessed = true;
            for (char letter : guessedLetters) {
                if (letter == '-') {
                    allLettersGuessed = false;
                    break;
                }
            }

            if (allLettersGuessed) {
                System.out.println("Congratulations! You guessed the word: " + correctAnswer);
                break;
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("Sorry, you ran out of attempts. The correct word was: " + correctAnswer);
        }
    }
}