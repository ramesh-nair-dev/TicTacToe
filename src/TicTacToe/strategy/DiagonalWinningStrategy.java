package TicTacToe.strategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    private Map<Character, Integer> leftDiagonalCount = new HashMap<>();
    private Map<Character, Integer> rightDiagonalCount = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character symbol = move.getPlayer().getSymbol().getSymbol();
        int size = board.getSize();

        if(row == col){
            leftDiagonalCount.put(symbol,leftDiagonalCount.getOrDefault(symbol,0)+1);
            if(leftDiagonalCount.get(symbol) == size){
                return true;
            }
        }

        if(row+col == size-1){
            rightDiagonalCount.put(symbol, rightDiagonalCount.getOrDefault(symbol, 0) + 1);

            if (rightDiagonalCount.get(symbol) == size) {
                return true;
            }
        }

        return false;
    }
}
