package TicTacToe.strategy;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy {
    private HashMap<Integer,HashMap<Character,Integer>> countRow = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        /*
        Logic for row winning Strategy is that we will have 2d hashmap
        0th row : <x : 1> , <y:1>
        what does this mean the in 0th row we have sybmol x one and sybmol y one time if player played move on
        0 th index and symbol is x so we update the <X:2>
        suppose after few turn we are in state that
        2 th row : <X:2> board is 3*3 to win player with symbol x need to make one move now player with symbol x plays
        move at 2 row now x:3 it equal to board size this player won the game
         */

        int row = move.getCell().getRow();
        Character symbol = move.getPlayer().getSymbol().getSymbol();

        if(!countRow.containsKey(row)){
            countRow.put(row , new HashMap<>());
        }

        HashMap<Character,Integer> count = countRow.get(row);

        if(!count.containsKey(symbol)){
            count.put(symbol,0);
        }

        count.put(symbol,count.get(symbol)+1);

        if(count.get(symbol) == board.getSize()){
            return  true;
        }

        return false;


    }
}
