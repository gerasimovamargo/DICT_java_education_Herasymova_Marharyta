package CoffeeMachine;
import java.util.Scanner;
public class CoffeeMachine {
    public static void main (String args[]){
        basicCupCalc();
    }

    static void basicCupCalc() {
        System.out.print("Write how many cups you want: ");

           Scanner scanner = new Scanner(System.in);
           String nCups = scanner.nextLine();

        int answer = Integer.parseInt(nCups);
            System.out.printf("For %d cups of coffee you will need %n", answer);
            System.out.printf("%d ml of water%n", answer * 200);
            System.out.printf("%d ml of milk%n", answer * 50);
            System.out.printf("%d g of beans%n", answer * 15);
    }
}