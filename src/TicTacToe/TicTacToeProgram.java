package TicTacToe;
public class TicTacToeProgram {
    public static java.util.Scanner in;

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");
        var core = new GameBoard();
        core.startGame();
    }
}
