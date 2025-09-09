package TicTacToe.models;

import TicTacToe.strategy.BotPlayingStrategy;
import TicTacToe.strategy.BotPlayingStrategyFactory;

public class BotPlayer extends Player {
    BotLevel botLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public BotPlayer(int id, String name, Symbol symbol, PlayerType playerType,BotLevel botLevel) {
        super(id, name, symbol, playerType);
        this.botLevel = botLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botLevel);
    }

    @Override
    public Move makeMove(Board board){
        return botPlayingStrategy.makeMove(board);
    }
}
