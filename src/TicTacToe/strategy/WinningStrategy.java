package TicTacToe.strategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface WinningStrategy{
    public boolean checkWinner(Board board , Move move);
    // to check winner what are the minimum requirement we need we need the board , and Move move to know which player played the last move

}
