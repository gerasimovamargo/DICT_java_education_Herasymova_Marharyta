package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    static int state = 1;
    /*1 - menu, 2 - buy, 3 - fill*/

    public static void main(String[] args) {
        CoffeeIngredient ingredients = new CoffeeIngredient();

        while (state != 0) {
            answerHandler(state, ingredients);
        }
    }

    static void menu(CoffeeIngredient ingredients, String answer) {
        switch (answer) {
            case "buy" -> state = 2;
            case "fill" -> state = 3;
            case "take" -> ingredients.take();
            case "exit" -> System.exit(0);
            case "remaining" -> ingredients.status();
            default -> System.out.println("Incorrect input!");
        }
    }

    static void buy(CoffeeIngredient ingredients, String answer) {
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

    static void answerHandler(int s, CoffeeIngredient ingredients) {
        Scanner scanner = new Scanner(System.in);
        String[] outputOptions = {"Write action (buy, fill, take, remaining, exit):",
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino or back to return to main menu:"};
        switch (s) {
            case 1:
                System.out.println(outputOptions[0]);
                break;
            case 2:
                System.out.println(outputOptions[1]);
                break;
            case 3:
                if (ingredients.row == 0) {
                    ingredients.row = 1;
                }
                ingredients.fillAsk();
                break;
        }
        String answer = scanner.nextLine();

        switch (s) {
            case 1:
                menu(ingredients, answer);
                break;
            case 2:
                buy(ingredients, answer);
                state = 1;
                break;
            case 3:
                ingredients.fill(answer);
                if (ingredients.row > 4) {
                    ingredients.row = 0;
                    state = 1;
                }
                break;
        }
    }
}