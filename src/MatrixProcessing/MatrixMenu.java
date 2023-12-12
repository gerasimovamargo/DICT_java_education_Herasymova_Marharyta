package MatrixProcessing;

import java.util.Scanner;

public class MatrixMenu {
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        label:
        while (true) {
            System.out.print("""
                    Welcome to the matrix calculator
                    1. Sum of the matrix
                    2. Multiply matrix by constant
                    3. Multiply matrix
                    4. Transpose matrix
                    5. Determinant of matrix
                    6. Inverse matrix
                    7. Exit
                    Choose your action:
                    """);
            String action = scanner.next();
            switch (action) {
                case "1":
                    new MatrixOperations().sumOfMatrix();
                    break;
                case "2":
                    new MatrixOperations().constantMatrix();
                    break;
                case "3":
                    new MatrixOperations().multiplyMatrix();
                    break;
                case "4":
                    menuTransport(scanner);
                    break;
                case "5":
                    new MatrixOperations().determinantOfMatrix();
                    break;
                case "exit":
                    break label;
            }
        }
    }

    public void menuTransport(Scanner scanner) {
        MatrixOperations matrixOperations = new MatrixOperations();
        System.out.print("""
            1. Main diagonal
            2. Side diagonal
            3. Vertical line
            4. Horizontal line
            """);
        String choice = scanner.next();
        switch (choice) {
            case "1" -> matrixOperations.transportMainDiagonal();
            case "2" -> matrixOperations.transportSideDiagonal();
            case "3" -> matrixOperations.transportVerticalLine();
            case "4" -> matrixOperations.transportHorizontalLine();
        }
    }
}
