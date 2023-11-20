package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        CoffeeIngredient ingredients = new CoffeeIngredient();


        while (true) {
            if (!menu(ingredients)) {
                break;
            }
        }
    }

    static boolean menu(CoffeeIngredient ingredients) {
        ingredients.status();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String answer = scanner.nextLine();

        switch (answer) {
            case "buy" -> buy(ingredients);
            case "fill" -> ingredients.fill();
            case "take" -> ingredients.take();
            case "exit" -> {
                return false;
            }
            case "remaining" -> ingredients.status();
            default -> System.out.println("Incorrect input!");
        }
        return true;
    }

    static void buy(CoffeeIngredient ingredients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3" +
                " - cappuccino or back to return to main menu:");
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                ingredients.espresso();
                System.out.println("I gave you Espresso");
                break;
            case "2":
                ingredients.latte();
                System.out.println("I gave you Latte");
                break;
            case "3":
                ingredients.cappuccino();
                System.out.println("I gave you Cappuccino");
                break;
            case "back":
                System.out.println("Operation interrupted");
                break;
            default:
                System.out.println("Incorrect input!");
                break;
        }
    }
}


