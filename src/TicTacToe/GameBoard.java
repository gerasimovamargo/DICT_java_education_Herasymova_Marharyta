package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    private int size;
    private final Process[][] field;
    private TicTacToePlayer currentPlayer;
    private final TicTacToePlayer firstPlayer;
    private final TicTacToePlayer secondPlayer;
    private final Scanner scanner;

    public GameBoard() {
        scanner = new Scanner(System.in);
        setGameBoardSize();
        firstPlayer = new TicTacToePlayer('X');
        secondPlayer = new TicTacToePlayer('O');
        currentPlayer = firstPlayer;
        field = new Process[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                field[row][col] = new Process();
            }
        }
    }

    private void setGameBoardSize() {
        while (true) {
            System.out.println("Enter the size of the game field: ");
            var input = scanner.nextLine();
            try {
                var fieldSize = Integer.parseInt(input);
                if (fieldSize < 2 || fieldSize > 10) {
                    System.out.println("Enter a number in the range 2 to 10");
                    continue;
                }
                this.size = fieldSize;
                return;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
            }
        }
    }

    public void startGame() {
        printField();
        while (true) {
            doMove();
            printField();
            var result = checkResult();
            if (result.win) {
                win(result.player);
                break;
            }
            if (result.draw) {
                draw();
                break;
            }
            changePlayer();
        }
    }

    private void win(TicTacToePlayer player) {
        System.out.println(player.getSymbol().toString() + " Won!");
    }

    private void draw() {
        System.out.println("Draw!");
    }

    private void doMove() {
        while (true) {
            var coords = getCordsFromPlayer();
            if (!isCellTaken(coords)) {
                field[coords[0]][coords[1]].setCellTaken(true);
                field[coords[0]][coords[1]].setNewPlayer(currentPlayer);
                break;
            }
            System.out.println("Cell is already taken. Choose another one.");
        }
    }

    private boolean isCellTaken(int[] coords) {
        return field[coords[0]][coords[1]].isCellTaken();
    }

    private int[] getCordsFromPlayer() {
        while (true) {
            String input = getPlayerInput();
            int[] coords = parseInput(input);

            if (isValidInput(coords)) {
                return coords;
            }
        }
    }

    private String getPlayerInput() {
        System.out.println("Player \"" + currentPlayer.getSymbol().toString() + "\" Enter the coordinates (row column):");
        return scanner.nextLine();
    }

    private int[] parseInput(String input) {
        try {
            String[] inputArray = input.split(" ");
            if (inputArray.length != 2) {
                System.out.println("Invalid input. Enter two numbers separated by space.");
                return null;
            }

            int row = Integer.parseInt(inputArray[0]) - 1;
            int col = Integer.parseInt(inputArray[1]) - 1;

            return new int[]{row, col};
        } catch (NumberFormatException e) {
            System.out.println("You should enter valid numbers!");
            return null;
        }
    }

    private boolean isValidInput(int[] coords) {
        if (coords == null) {
            return false;
        }

        int row = coords[0];
        int col = coords[1];

        if (row < 0 || row >= size || col < 0 || col >= size) {
            System.out.println("Invalid coordinates. Choose again.");
            return false;
        }

        if (isCellTaken(coords)) {
            System.out.println("Cell is already taken. Choose another one.");
            return false;
        }

        return true;
    }

    private GameResult checkResult() {

        for (int i = 0; i < size; i++) {
            if (checkLine(field[i]) || checkLine(getColumn(i)) || checkDiagonals()) {
                return new GameResult(true, currentPlayer);
            }
        }

        boolean draw = Arrays.stream(field)
                .allMatch(row -> Arrays.stream(row)
                        .allMatch(Process::isCellTaken));
        return new GameResult(draw);
    }

    private boolean checkLine(Process[] line) {
        TicTacToePlayer player = line[0].getPlayer();
        return Arrays.stream(line).allMatch(p -> p.isCellTaken() && p.getPlayer().equals(player));
    }

    private Process[] getColumn(int col) {
        Process[] column = new Process[size];
        for (int i = 0; i < size; i++) {
            column[i] = field[i][col];
        }
        return column;
    }

    private boolean checkDiagonals() {
        return checkLine(getDiagonal(true)) || checkLine(getDiagonal(false));
    }

    private Process[] getDiagonal(boolean fromTopLeft) {
        Process[] diagonal = new Process[size];
        int step = fromTopLeft ? 1 : -1;
        int startCol = fromTopLeft ? 0 : size - 1;

        for (int i = 0; i < size; i++) {
            diagonal[i] = field[i][startCol + i * step];
        }

        return diagonal;
    }

    private String buildField() {
        StringBuilder board = new StringBuilder();
        board.append("┌");
        for (int i = 0; i < size; i++) {
            board.append("─────");
            if (i < size - 1) {
                board.append("┬");
            }
        }
        board.append("┐\n");

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board.append("│  ");
                board.append(field[row][col].getSymbol().toString());
                board.append("  ");
            }
            board.append("│\n");
            if (row == size - 1) {
                board.append("└");
                for (int col = 0; col < size; col++) {
                    board.append("─────");
                    if (col != size - 1) {
                        board.append("┴");
                    }
                }
                board.append("┘\n");
            } else {
                for (int col = 0; col < size; col++) {
                    if (col == 0) board.append("├");
                    else board.append("┼");
                    board.append("─────");
                }
                board.append("┤\n");
            }
        }

        return board.toString();
    }

    private void printField() {
        System.out.println(buildField());
    }

    private void changePlayer() {
        currentPlayer = (currentPlayer == firstPlayer) ? secondPlayer : firstPlayer;
    }
}
