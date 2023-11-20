package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    static void menu() {
        CoffeeIngredient ingredients = new CoffeeIngredient();
        ingredients.status();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take):");
        String answer = scanner.nextLine();
        switch (answer) {
            case "buy" -> buy(ingredients);
            case "fill" -> ingredients.fill();
            case "take" -> ingredients.take();
            default -> System.out.println("Incorrect input!");
        }
    }

    static void buy(CoffeeIngredient ingredients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int answer = Integer.parseInt(scanner.nextLine());
        switch (answer) {
            case 1:
                ingredients.espresso();
                break;
            case 2:
                ingredients.latte();
                break;
            case 3:
                ingredients.cappuccino();
                break;
            default:
                System.out.println("Incorrect input!");
        }
    }
}
