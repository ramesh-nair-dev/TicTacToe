package TicTacToe.controller;

import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;
import TicTacToe.strategy.WinningStrategy;

import java.util.List;

public class gameController {


    public Game startGame(
            int dimension,
            List<Player> players,
            List<WinningStrategy> winningStrategies
    ){
        return Game.getBuilder().
                setSize(dimension).
                setPlayers(players).
                setWinningStrategies(winningStrategies).
                Build();
    }

    public void makeMove(Game game){
        game.makeMove();
        /*
        to implement make move we won't implement it here directly rather we will say hey game makeMove
        now in game class we will implement makeMove() method
         */
    }

    public void undo(Game game){
        game.undo();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void display(Game game){
        // to display game we won't directly display from gameController we will say hey game display your self
        game.display();
    }



}

/**
 * --------------------------------------------------------------------------------
 * Recruiter-Friendly Comments:
 *
 * - The `gameController` class acts as a mediator between the client and the core game logic, following the Controller pattern.
 * - It does not store any game state internally, which allows multiple games to be managed independently and avoids shared state bugs.
 * - The `startGame` method uses the Builder pattern to construct a `Game` object, promoting immutability and clarity in object creation.
 * - All game actions (`makeMove`, `undo`, `display`) are delegated to the `Game` object, ensuring single responsibility and encapsulation.
 * - The controller exposes only necessary methods to interact with the game, keeping the API clean and focused.
 * - This design is extensible, testable, and aligns with SOLID principles, especially Single Responsibility and Open/Closed.
 * - The code is modular, easy to maintain, and demonstrates best practices in object-oriented design.
 * --------------------------------------------------------------------------------
 */