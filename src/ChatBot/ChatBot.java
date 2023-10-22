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
    }
}