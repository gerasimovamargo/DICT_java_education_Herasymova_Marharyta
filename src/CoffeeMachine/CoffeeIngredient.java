package CoffeeMachine;
public class CoffeeIngredient {

    public int water = 400;
    public int milk = 540;
    public int beans = 120;
    public int money = 550;
    public int cups = 9;
    public int row = 0;

    void fillAsk() {
        switch (row) {
            case 1:
                System.out.print("Write how many ml of water to add to the coffee machine: ");
                break;
            case 2:
                System.out.print("Write how many ml of milk to add to the coffee machine : ");
                break;
            case 3:
                System.out.print("Write how many g of beans to add to the coffee machine: ");
                break;
            case 4:
                System.out.print("Write how many cups to add to the coffee machine: ");
                break;
        }
    }

    void fill(String input) {
        int inputInt = Integer.parseInt(input);
        switch (row) {
            case 1 -> water += inputInt;
            case 2 -> milk += inputInt;
            case 3 -> beans += inputInt;
            case 4 -> cups += inputInt;
        }
        row += 1;
    }

         void status() {
            System.out.print("The coffee machine has: ");
            System.out.printf("%d ml of water%n", water);
            System.out.printf("%d ml of milk%n", milk);
            System.out.printf("%d g of beans%n", beans);
            System.out.printf("%d cups%n", cups);
            System.out.printf("%d grn of money%n", money);
             }

       void take() {
           System.out.println("I gave you " + money + " grn");
           money = 0;
          }

        void espresso() {
             if ((water - 250) >= 0 && (beans - 16) >= 0) {
             water -= 250;
             beans -= 16;
             cups -= 1;
             money += 4;
           }
             else {
            System.out.println("Sorry, not enough " + notEnough(250, 0, 16));
        }
    }

           void latte() {
              if ((water - 350) >= 0 && (milk - 75) >= 0 && (beans - 20) >= 0) {
            water -= 350;
            milk -= 75;
            beans -= 20;
            cups -= 1;
            money += 7;
            }
              else {
            System.out.println("Sorry, not enough " + notEnough(200, 100, 12));
        }
    }

        void cappuccino() {
            if ((water - 200) >= 0 && (milk - 100) >= 0 && (beans - 12) >= 0) {
            water -= 200;
            milk -= 100;
            beans -= 12;
            cups -= 1;
            money += 6;
        }
            else {
            System.out.println("Sorry, not enough " + notEnough(200, 100, 12));
        }
    }

    String notEnough(int a, int b, int c) {
        if ((water - a) < 0) {
            return "water";
        } else if ((milk - b) < 0) {
            return "milk";
        } else if ((beans - c) < 0) {
            return "beans";
        } else {
            return "cups";
        }
    }
}
