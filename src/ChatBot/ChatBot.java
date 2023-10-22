package ChatBot;
import java.util.Scanner;

public class ChatBot {

    public static void main(String[] args) {

        System.out.println("Hello! My name is SomeBot");
        System.out.println("I was created in 2023");

        System.out.println("Please remind me your name.");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        System.out.printf("What a great name you have, %s!%n", answer);

        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();
        int age = (num1 * 70 + num2 * 21 + num3 * 15) % 105;
        System.out.printf("Your age is %s; that's a good time to start programming!%n", age);


        System.out.println("Now I will prove to you that I can count to any number you want!");
        int GNumber = in.nextInt();

        for (int i = 1; i <= GNumber; i++) {
            System.out.printf("\"%d!\"%n", i);
        }


        System.out.println("Now answer my question. How to output text to the console in \"Java\"?");
        System.out.println("""
                1. print("Hello, World!");
                2. System.print("Hello, World!");
                3. System.out.print("Hello, World!");
                4. console.log("Hello, World!");""");

        int correctAnswer = 3;
        Scanner scanner = new Scanner(System.in);
        int userAnswer;

        do {
            System.out.print("Enter the number of the correct answer: ");
            userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.println("The answer is incorrect. Please try again.");
            }
        } while (userAnswer != correctAnswer);

        System.out.println("Congratulations! You answered correctly.");
        System.out.println("Goodbye, have a nice day!");
    }
}
