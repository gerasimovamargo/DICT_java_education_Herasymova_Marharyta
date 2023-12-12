package CreditCalculator;

public class CreditCalculator {

    double loanInterest;
    double loanPrincipal;
    double numberOfMonth;
    double monthPayment;
    double i;
    double diffPayment;

    public void countingRate(){
        System.out.println("Enter a loan interest:");
        loanInterest = CalculatorMain.scanner.nextDouble();
        i =  (loanInterest/(12*100));
    }


    public void countingPay(){
        System.out.println("Enter a loan principal:");
        loanPrincipal = CalculatorMain.scanner.nextDouble();
        System.out.println("Enter the number of periods:");
        numberOfMonth= CalculatorMain.scanner.nextInt();
        countingRate();
        monthPayment = loanPrincipal*((i*Math.pow((1+i),numberOfMonth))/(Math.pow((1+i),numberOfMonth)-1));
        System.out.printf("Your monthly payment = %.0f", monthPayment);
    }

    public void countingMonth(){
        System.out.println("Enter a loan principal:");
        loanPrincipal = CalculatorMain.scanner.nextInt();
        System.out.println("Enter the monthly payment:");
        monthPayment = CalculatorMain.scanner.nextInt();
        countingRate();
        numberOfMonth = Math.log(monthPayment/(monthPayment-(i*loanPrincipal)))/Math.log(1+i);
        getPeriod();
    }

    public void  countingPrincipal(){
        System.out.println("Enter the monthly payment:");
        monthPayment = CalculatorMain.scanner.nextDouble();
        System.out.println("Enter the number of periods:");
        numberOfMonth= CalculatorMain.scanner.nextInt();
        countingRate();
        loanPrincipal=monthPayment/((i*Math.pow((1+i),numberOfMonth))/(Math.pow((1+i),numberOfMonth)-1));
        System.out.printf("Your loan principal = %.0f", loanPrincipal);
    }

    public void getPeriod(){
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

    public void chooseAction() {
        System.out.println("""
                What do you want to calculate?
                type "n" - for number of monthly payments,
                type "a" - for annuity monthly payment amount,
                type "p" - for the loan principal:""");
        String action = CalculatorMain.scanner.next();
        switch (action){
            case "n":
                countingMonth();
                break;
            case "a":
                countingPay();
                break;
            case "p":
                countingPrincipal();
                break;
        }
    }
}
