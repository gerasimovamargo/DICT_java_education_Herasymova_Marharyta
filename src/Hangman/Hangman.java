package Hangman;
import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        System.out.println("The game will be available soon");

        String[] answers = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();

        String state;
        while (true) {
            int select = random.nextInt(answers.length);
            String correctAnswer = answers[select];
            Scanner scanner = new Scanner(System.in);
            int lives = 8;
            StringBuilder line = new StringBuilder();
            line.append("-".repeat(correctAnswer.length()));
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: ");
            state = scanner.nextLine();
            if (state.equals("exit")) {
                break;
            } else if (!state.equals("play")) {
                System.out.println("Unrecognized command, repeat please");
                continue;
            }
            while (lives > 0) {
                System.out.printf("The word is %s!%n", line);
                if (!line.toString().contains("-")) {
                    System.out.println("You guessed the word!\n" +
                     "You survived!");
                    break;
                }
                System.out.printf("You currently have %s lives!%n", lives);
                System.out.print("Enter the letter: ");
                String userAnswer = scanner.nextLine();
                if (userAnswer.length() != 1) {
                    System.out.println("You should input a single letter");
                    continue;
                }
                char userChar = userAnswer.charAt(0);
                if (Character.isUpperCase(userChar)) {
                    System.out.println("Please enter a lowercase English letter");
                    continue;
                }
                if (line.toString().contains(String.valueOf(userChar))) {
                    System.out.println("You've already guessed this letter.");
                } else if (!correctAnswer.contains(String.valueOf(userChar))) {
                    System.out.println("You lost!");
                    lives--;
                } else {
                    StringBuilder subLine = new StringBuilder();
                    for (int i = 0; i < correctAnswer.length(); i++) {
                        if (correctAnswer.charAt(i) == userChar) {
                            subLine.append(userChar);
                        } else if (line.charAt(i) != '-') {
                            subLine.append(line.charAt(i));
                        } else {
                            subLine.append("-");
                        }
                    }
                    line = new StringBuilder(subLine.toString());
                }
            }
            if (lives == 0) {
                System.out.println("Thanks for playing!");
            }

        }
    }
}