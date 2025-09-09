package TicTacToe.strategy;

import TicTacToe.models.BotLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotLevel botLevel){
        if(botLevel.equals(BotLevel.EASY)){
            return new EasyBotPlayingStrategy();
        }
        else{
            return null;
        }
    }
}
