package TicTacToe;
public class TicTacToePlayer {
    private final Character symbol;
    public TicTacToePlayer(Character symbol) {
        this.symbol = symbol;
    }
    public TicTacToePlayer() {
        this.symbol = ' ';
    }
    public Character getSymbol() {
        return symbol;
    }
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return symbol == ((TicTacToePlayer) obj).symbol;
    }
}
