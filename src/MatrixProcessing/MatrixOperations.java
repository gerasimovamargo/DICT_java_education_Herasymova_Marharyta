package MatrixProcessing;

import java.util.Scanner;

public class MatrixOperations {
    Scanner scanner = new Scanner(System.in);

    public void sumOfMatrix() {
        System.out.print("Enter parametric n(lines): ");
        int n = this.scanner.nextInt();
        System.out.print("Enter parametric m (rows): ");
        int m = this.scanner.nextInt();
        int[][] a = new int[n][m];
        System.out.println("Enter the matrix values in order: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = this.scanner.nextInt();
            }
        }
        System.out.print("Enter parametric n(lines): ");
        int n1 = this.scanner.nextInt();
        System.out.print("Enter parametric m (rows): ");
        int m1 = this.scanner.nextInt();
        int[][] b = new int[n1][m1];
        System.out.println("Enter the matrix values in order: ");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                b[i][j] = this.scanner.nextInt();
            }
        }

        if (a.length == b.length) {
            System.out.println("First Matrix: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Second Matrix: ");
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    System.out.print(b[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Sum of the matrix: ");
            int[][] c = new int[n][m];
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {

                    c[i][j] = a[i][j] + b[i][j];
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("ERROR");
        }
    }

    public void constantMatrix() {
        System.out.print("Enter parametric n(lines): ");
        int n = scanner.nextInt();
        System.out.print("Enter parametric m (rows): ");
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        System.out.println("Enter the matrix values in order: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.print("Enter a constant: ");
        int constValue = scanner.nextInt();
        System.out.println("New matrix: ");
        int[][] c = new int[n][m];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                c[i][j] = a[i][j] * constValue;
                System.out.print(c[i][j] + " ");

            }
            System.out.println();
        }
    }

    public void multiplyMatrix() {
        int[] sizeFirstMatrix = new int[2];
        System.out.print("Enter size of first matrix : ");
        for (int i = 0; i < 2; i++) {
            sizeFirstMatrix[i] = this.scanner.nextInt();
        }
        double[][] firstMatrix = new double[sizeFirstMatrix[0]][sizeFirstMatrix[1]];
        System.out.println("Enter the values of first matrix : ");
        for (int i = 0; i < sizeFirstMatrix[0]; i++) {
            for (int j = 0; j < sizeFirstMatrix[1]; j++) {
                firstMatrix[i][j] = this.scanner.nextDouble();
            }
        }
        int[] sizeSecondMatrix = new int[2];
        System.out.print("Enter size of second matrix : ");
        for (int i = 0; i < 2; i++) {
            sizeSecondMatrix[i] = this.scanner.nextInt();
        }
        double[][] secondMatrix = new double[sizeSecondMatrix[0]][sizeSecondMatrix[1]];
        System.out.println("Enter the values of second matrix E: ");
        for (int i = 0; i < sizeSecondMatrix[0]; i++) {
            for (int j = 0; j < sizeSecondMatrix[1]; j++) {
                secondMatrix[i][j] = this.scanner.nextDouble();
            }
        }

        System.out.println("First Matrix: ");
        for (int i = 0; i < sizeFirstMatrix[0]; i++) {
            for (int j = 0; j < sizeFirstMatrix[1]; j++) {
                System.out.print(firstMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Second Matrix: ");
        for (int i = 0; i < sizeSecondMatrix[0]; i++) {
            for (int j = 0; j < sizeSecondMatrix[1]; j++) {
                System.out.print(secondMatrix[i][j] + " ");
            }
            System.out.println();
        }

        double[][] multiplyMatrix = new double[sizeFirstMatrix[0]][sizeSecondMatrix[1]];
        for (int m = 0; m < sizeFirstMatrix[0]; m++) {
            for (int n = 0; n < sizeSecondMatrix[1]; n++) {
                multiplyMatrix[m][n] = 0;
            }
        }

        if (sizeFirstMatrix[1] == sizeSecondMatrix[0]) {
            System.out.println("Multiply Matrix");
            for (int v = 0; v < sizeFirstMatrix[0]; v++) {
                for (int z = 0; z < sizeSecondMatrix[1]; z++) {
                    for (int x = 0; x < sizeFirstMatrix[1]; x++) {
                        multiplyMatrix[v][z] = multiplyMatrix[v][z] + firstMatrix[v][x] * secondMatrix[x][z];
                    }
                    System.out.print(multiplyMatrix[v][z] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("ERROR");
        }
    }

    public void transportMatrix() {
        System.out.print("Enter size of the matrix : ");
        int[] sizeMatrix = new int[2];
        for (int i = 0; i < 2; i++) {
            sizeMatrix[i] = scanner.nextInt();
        }
        int[][] myMatrix = new int[sizeMatrix[0]][sizeMatrix[1]];
        System.out.println("Enter the values of the matrix : ");
        for (int i = 0; i < sizeMatrix[0]; i++) {
            for (int j = 0; j < sizeMatrix[1]; j++) {
                myMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Original Matrix: ");
        for (int i = 0; i < sizeMatrix[0]; i++) {
            for (int j = 0; j < sizeMatrix[1]; j++) {
                System.out.print(myMatrix[i][j] + " ");
            }
            System.out.println();
        }

        int[][] transposeMatrix = new int[sizeMatrix[1]][sizeMatrix[0]];

        System.out.println("Transpose Matrix: ");
        for (int n = 0; n < sizeMatrix[1]; n++) {
            for (int m = 0; m < sizeMatrix[0]; m++) {
                transposeMatrix[n][m] = myMatrix[m][n];
                System.out.print(transposeMatrix[n][m] + " ");
            }
            System.out.println();
        }
    }

    public void transportMainDiagonal() {
        int[][] myMatrix = new int[0][0];
        transportMatrix();
    }

    public void transportSideDiagonal() {
        int[][] myMatrix = new int[0][0];
        transportMatrix();
    }

    public void transportMatrix(boolean isVertical) {
        int[] sizeMatrix = new int[2];
        System.out.print("Enter size of the matrix : ");
        for (int i = 0; i < 2; i++) {
            sizeMatrix[i] = scanner.nextInt();
        }
        double[][] myMatrix = new double[sizeMatrix[0]][sizeMatrix[1]];
        System.out.println("Enter the values of the matrix : ");
        for (int i = 0; i < sizeMatrix[0]; i++) {
            for (int j = 0; j < sizeMatrix[1]; j++) {
                myMatrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("First Matrix: ");
        for (int i = 0; i < sizeMatrix[0]; i++) {
            for (int j = 0; j < sizeMatrix[1]; j++) {
                System.out.print(myMatrix[i][j] + " ");
            }
            System.out.println();
        }

        double[][] transposeMatrix = new double[sizeMatrix[1]][sizeMatrix[0]];

        System.out.println("Transpose matrix: ");
        for (int n = 0; n < sizeMatrix[0]; n++) {
            for (int m = 0; m < sizeMatrix[1]; m++) {
                if (isVertical) {
                    transposeMatrix[n][m] = myMatrix[n][sizeMatrix[1] - 1 - m];
                } else {
                    transposeMatrix[n][m] = myMatrix[sizeMatrix[0] - 1 - n][m];
                }
                System.out.print(transposeMatrix[n][m] + " ");
            }
            System.out.println();
        }
    }

    public void transportVerticalLine() {
        transportMatrix(true);
    }

    public void transportHorizontalLine() {
        transportMatrix(false);
    }

    public void determinantOfMatrix() {
        int[] sizeMatrix = new int[2];
        System.out.print("Enter size of the matrix : ");
        for (int i = 0; i < 2; i++) {
            sizeMatrix[i] = scanner.nextInt();
        }
        double[][] myMatrix = new double[sizeMatrix[0]][sizeMatrix[1]];
        System.out.println("Enter the values of the matrix : ");
        for (int i = 0; i < sizeMatrix[0]; i++) {
            for (int j = 0; j < sizeMatrix[1]; j++) {
                myMatrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Matrix: ");
        for (int i = 0; i < sizeMatrix[0]; i++) {
            for (int j = 0; j < sizeMatrix[1]; j++) {
                System.out.print(myMatrix[i][j] + " ");
            }
            System.out.println();
        }

        int determinant = 0;
        if (sizeMatrix[0] == 2) {
            determinant = (int) (myMatrix[0][0] * myMatrix[1][1] - myMatrix[0][1] * myMatrix[1][0]);
        } else if (sizeMatrix[0] == 3) {
            determinant = (int) (myMatrix[0][0] * myMatrix[1][1] * myMatrix[2][2] +
                    myMatrix[0][1] * myMatrix[1][2] * myMatrix[2][0] +
                    myMatrix[0][2] * myMatrix[1][0] * myMatrix[2][1] -
                    myMatrix[0][2] * myMatrix[1][1] * myMatrix[2][0] -
                    myMatrix[0][0] * myMatrix[1][2] * myMatrix[2][1] -
                    myMatrix[0][1] * myMatrix[1][0] * myMatrix[2][2]);
        } else if (sizeMatrix[0] == 4) {
            int firstMinor = (int) (myMatrix[1][0] * myMatrix[2][1] * myMatrix[3][2] +
                    myMatrix[1][1] * myMatrix[2][2] * myMatrix[3][0] +
                    myMatrix[1][2] * myMatrix[2][0] * myMatrix[3][1] -
                    myMatrix[1][2] * myMatrix[2][1] * myMatrix[3][0] -
                    myMatrix[1][0] * myMatrix[2][2] * myMatrix[3][1] -
                    myMatrix[1][1] * myMatrix[2][0] * myMatrix[3][2]);

            int secondMinor = (int) (myMatrix[0][0] * myMatrix[2][1] * myMatrix[3][2] +
                    myMatrix[0][1] * myMatrix[2][2] * myMatrix[3][0] +
                    myMatrix[0][2] * myMatrix[2][0] * myMatrix[3][1] -
                    myMatrix[0][2] * myMatrix[2][1] * myMatrix[3][0] -
                    myMatrix[0][0] * myMatrix[2][2] * myMatrix[3][1] -
                    myMatrix[0][1] * myMatrix[2][0] * myMatrix[3][2]);

            int thirdMinor = (int) (myMatrix[0][0] * myMatrix[1][1] * myMatrix[3][2] +
                    myMatrix[0][1] * myMatrix[1][2] * myMatrix[3][0] +
                    myMatrix[0][2] * myMatrix[1][0] * myMatrix[3][1] -
                    myMatrix[0][2] * myMatrix[1][1] * myMatrix[3][0] -
                    myMatrix[0][0] * myMatrix[1][2] * myMatrix[3][1] -
                    myMatrix[0][1] * myMatrix[1][0] * myMatrix[3][2]);

            int fourthMinor = (int) (myMatrix[0][0] * myMatrix[1][1] * myMatrix[2][2] +
                    myMatrix[0][1] * myMatrix[1][2] * myMatrix[2][0] +
                    myMatrix[0][2] * myMatrix[1][0] * myMatrix[2][1] -
                    myMatrix[0][2] * myMatrix[1][1] * myMatrix[2][0] -
                    myMatrix[0][0] * myMatrix[1][2] * myMatrix[2][1] -
                    myMatrix[0][1] * myMatrix[1][0] * myMatrix[2][2]);

            determinant = (int) (-myMatrix[0][3] * firstMinor + myMatrix[1][3] * secondMinor - myMatrix[2][3] * thirdMinor +
                    myMatrix[3][3] * fourthMinor);
        }
        System.out.println("Determinant is " + determinant);
    }
}
