package TicTacToe;
public class GameResult {

    public boolean win = false;
    public boolean draw = false;
    public TicTacToePlayer player;

    public GameResult(boolean win, TicTacToePlayer player) {
        this.win = win;
        this.player = player;
    }

    public GameResult(boolean draw) {
        this.draw = draw;
    }
}
