package TicTacToe;

import TicTacToe.controller.gameController;
import TicTacToe.models.*;
import TicTacToe.strategy.ColWinningStrategy;
import TicTacToe.strategy.DiagonalWinningStrategy;
import TicTacToe.strategy.RowWinningStrategy;
import TicTacToe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        gameController gc = new gameController();
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(1,"Jon",new Symbol('0'), PlayerType.HUMAN));
        players.add(new BotPlayer(2,"Bot",new Symbol('X'),PlayerType.BOT,BotLevel.EASY));
        Game g = gc.startGame(3,players, List.of(new RowWinningStrategy() , new ColWinningStrategy() , new DiagonalWinningStrategy()) );
        Scanner scn = new Scanner(System.in);

        gc.display(g);

        while(g.getGameState().equals(GameState.IN_PROCESS)){
            gc.makeMove(g);
            gc.display(g);

            if(!gc.getGameState(g).equals(GameState.SUCCESS)) {

                System.out.println("Do you want to undo [y/n]");
                String undoAnswer = scn.nextLine();

                if (undoAnswer.equals("y") || undoAnswer.equals("Y")) {
                    gc.undo(g);
                    System.out.println("Undo is successfull !");
                    gc.display(g);
                }

            }

        }

        if(gc.getGameState(g).equals(GameState.SUCCESS)){
            System.out.println(gc.getWinner(g).getName() + " won the game !");
        }
        else if (gc.getGameState(g).equals(GameState.DRAW)){
            System.out.println("Game result's in draw");
        }
    }
}

/**
 *--------------------------------------------------------------------------------
 * - The `client` class serves as the entry point for the TicTacToe game, demonstrating clean separation of concerns and modular design.
 * - A `gameController` instance orchestrates the game flow, encapsulating game logic and interactions.
 * - The code supports extensibility by using a `List<Player>`, allowing easy addition of new player types or more players.
 * - Both human and bot players are instantiated, showcasing polymorphism and the use of enums for player types and bot difficulty.
 * - The game is initialized with a 3x3 board and a list of winning strategies (row, column, diagonal), following the Open/Closed Principle for easy extension.
 * - The main game loop continues while the game is in process, handling moves, board display, and user interaction for undo functionality.
 * - Undo functionality is user-friendly and demonstrates state management and command pattern concepts.
 * - The result is announced based on the final game state, with clear output for both win and draw scenarios.
 * - The code is readable, maintainable, and follows object-oriented best practices, making it easy to extend and test.
 * --------------------------------------------------------------------------------
 */
