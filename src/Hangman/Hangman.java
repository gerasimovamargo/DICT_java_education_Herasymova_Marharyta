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

        String tip = correctAnswer.substring(0, 2) + "-".repeat(Math.max(0, correctAnswer.length() - 2));
        System.out.printf("Tip: the word is %s!%n", tip);

          System.out.print("Guess the word: ");
                Scanner scanner = new Scanner(System.in);
                String userAnswer = scanner.nextLine();

        if (userAnswer.equals(correctAnswer)) {
            System.out.println("You survived!");
        } else {
            while (!userAnswer.equals(correctAnswer)) {
                System.out.println("You lost!");
                System.out.printf("Tip: the words is %s!%n", tip);
                System.out.print("Guess the word: ");
                userAnswer = scanner.nextLine();
            }
            System.out.println("You survived!");


        }
    }
}

