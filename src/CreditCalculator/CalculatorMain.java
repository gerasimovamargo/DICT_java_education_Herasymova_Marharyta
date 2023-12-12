package CreditCalculator;
import java.util.Scanner;
public class CalculatorMain {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        double loanInterest;
        double loanPrincipal;
        double monthPayment;
        double i;
        double diffPayment;
        int overPay = 0;
        double numberOfMonth;
        String type = System.getProperty("type");
        String principal = System.getProperty("principal");
        String payment = System.getProperty("payment");
        String interest = System.getProperty("interest");
        String periods = System.getProperty("periods");

        if (type != null){
            if (type.equals("diff")) {
                if (principal == null || periods == null || interest == null) {
                    System.out.println("Incorrect parameters.");
                    System.exit(0);
                }

                numberOfMonth = Double.parseDouble(periods);
                loanPrincipal = Double.parseDouble(principal);
                loanInterest  =  Double.parseDouble(interest);

                i = (loanInterest / (12 * 100));

                for (int m = 1; m <= numberOfMonth; m++) {
                    diffPayment = loanPrincipal / numberOfMonth + i * (loanPrincipal - ((loanPrincipal * (m - 1)) / (numberOfMonth)));
                    diffPayment = Math.round(diffPayment);

                    overPay = (int) (overPay + (diffPayment - (loanPrincipal / numberOfMonth)));

                    System.out.println("Month " + m + ": payment is " + diffPayment);
                }
                System.out.println("Overpayment = " + overPay);
            } else if(type.equals("annuity")) {

                if(principal != null && payment != null && interest != null){

                    monthPayment  =  Double.parseDouble(payment);
                    loanPrincipal = Double.parseDouble(principal);
                    loanInterest  =  Double.parseDouble(interest);

                    i =  (loanInterest/(12*100));
                    numberOfMonth = Math.log(monthPayment/(monthPayment-(i*loanPrincipal)))/Math.log(1+i);

                    int period = (int) Math.round(numberOfMonth);
                    int year = (period / 12);
                    int month = (period % 12);

                    if (year>0 & month >0){
                        System.out.println("It will take " + year + " years and " + month + " month to repay this loan");
                    }
                    else if(year == 0){
                        System.out.println("It will take "  + month + " month to repay this loan");
                    }
                    else {
                        System.out.println("It will take "  + year + " years to repay this loan");
                    }
                }

                else if (periods != null && payment != null && interest != null) {

                    numberOfMonth = Double.parseDouble(periods);
                    monthPayment  =  Double.parseDouble(payment);
                    loanInterest  =  Double.parseDouble(interest);
                    i =  (loanInterest/(12*100));
                    loanPrincipal=monthPayment/((i*Math.pow((1+i),numberOfMonth))/(Math.pow((1+i),numberOfMonth)-1));

                    System.out.printf("Your loan principal = %.0f", loanPrincipal);
                }

                else if (principal != null && periods != null && interest != null){
                    loanPrincipal = Double.parseDouble(principal);
                    numberOfMonth = Double.parseDouble(periods);
                    loanInterest  =  Double.parseDouble(interest);
                    i =  (loanInterest/(12*100));
                    monthPayment = loanPrincipal*((i*Math.pow((1+i),numberOfMonth))/(Math.pow((1+i),numberOfMonth)-1));

                    System.out.printf("Your monthly payment = %.0f", monthPayment);
                }
            }else {
                System.out.println("Incorrect parameters.");
                System.exit(0);
            }
        } else {
            System.out.println("Incorrect parameters.");
            System.exit(0);
        }
    }
}
