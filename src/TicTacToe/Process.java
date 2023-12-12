package TicTacToe;

public class Process {

    private boolean isCellTaken;
    private TicTacToePlayer player;

    public Process() {
        isCellTaken = false;
        setNewPlayer(new TicTacToePlayer());
    }

    public void setNewPlayer(TicTacToePlayer player) {
        this.player = player;
    }

    public TicTacToePlayer getPlayer() {
        return player;
    }

    public Character getSymbol() {
        return player.getSymbol();
    }

    public boolean isCellTaken() {
        return isCellTaken;
    }

    public void setCellTaken(boolean isCellTaken ) {
        this.isCellTaken = isCellTaken;
    }
}
