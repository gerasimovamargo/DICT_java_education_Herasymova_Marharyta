package Hangman;
import java.util.Scanner;


public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon");

        String correctAnswer = "java";
          System.out.print("Guess the word: ");
                Scanner scanner = new Scanner(System.in);
                String userAnswer = scanner.nextLine();

        if (userAnswer.equals(correctAnswer)) {
            System.out.println("You survived!");
        } else {
            while (!userAnswer.equals(correctAnswer)) {
                System.out.println("You lost!");
                System.out.print("Guess the word: ");
                userAnswer = scanner.nextLine();
            }
            System.out.println("You survived!");
        }
    }
}