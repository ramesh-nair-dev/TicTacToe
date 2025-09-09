package TicTacToe.strategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

import java.util.HashMap;

public class ColWinningStrategy implements WinningStrategy{
    private HashMap<Integer,HashMap<Character,Integer>> countCol = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getCol();
        Character symbol = move.getPlayer().getSymbol().getSymbol();

        if(!countCol.containsKey(col)){
            countCol.put(col,new HashMap<>());
        }

        HashMap<Character,Integer> count = countCol.get(col);

        if(!count.containsKey(symbol)){
            count.put(symbol,0);
        }

        count.put(symbol,count.get(symbol)+1);

        if(count.get(symbol) == board.getSize()){
            return true;
        }
        return false;
    }
}
