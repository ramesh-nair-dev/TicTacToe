package TicTacToe.models;

import TicTacToe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player> playersList;
    private List<Move> moveList;
    private Player winner;
    private GameState gameState;
    private List<WinningStrategy> winingStrategyList;
    private int nextPlayerIndex;

    private Game(Builder builder){
        this.board = new Board(builder.getSize());
        this.playersList = builder.getPlayers();
        this.winingStrategyList = builder.getWinningStrategies();
        this.gameState = GameState.IN_PROCESS;
        this.nextPlayerIndex = 0;
        this.moveList = new ArrayList<>();
        this.winner = null;

    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Player> playersList) {
        this.playersList = playersList;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<WinningStrategy> getWiningStrategyList() {
        return winingStrategyList;
    }

    public void setWiningStrategyList(List<WinningStrategy> winingStrategyList) {
        this.winingStrategyList = winingStrategyList;
    }

    public void display(){
        // so to display game what we will do we just want to display the board so we will say hey board display ourself
        this.board.display();
    }

    public boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // we check if given row and col are with boundaries

        if(row<0 || row > board.getSize() || col<0 || col> board.getSize()){
            return false;
        }

        // we check if cellstate we wish to change is empty or not
        return board.getGrid().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public boolean checkWinner(Move move){
        for(WinningStrategy strategy : winingStrategyList){
            if(strategy.checkWinner(board,move)){
                return true;
            }
        }
        return  false;
    }

    public void undo(){
        if(moveList.isEmpty()){
            System.out.println("Nothing to undo");
            return;
        }
        Move lastMove = moveList.getLast();
        moveList.removeLast();

        lastMove.getCell().setCellState(CellState.EMPTY);
        lastMove.getCell().setSymbol(null);
        nextPlayerIndex --;
        nextPlayerIndex = (nextPlayerIndex+playersList.size())%playersList.size();


    }

    public void makeMove(){

        Player currentPlayer = playersList.get(nextPlayerIndex);

        // in game we implemented makeMove but in actuall who is responsible for making move it player right

        System.out.println("It's " + currentPlayer.getName()+" turn to make a move ...");

        Move move = currentPlayer.makeMove(board);
        // what we are doing we calling makeMove method from currentPlayer object it will return move object where player wish to make move

        if(!validateMove(move)){
            System.out.println("Not valid Move");
            return;
        }

        // before moving forward we check the if the move is valid or not

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        /* what we are doing here is that we are getting the row and col from move object which
        current player object makeMove return move object store the desired row and col we want to make move
        now here we retrive that
         */

        Cell cellToChange = board.getGrid().get(row).get(col);
        // in board we have List<List<cell>> we get that particular cell

        cellToChange.setCellState(CellState.FILLED);
        // we change the state of that cell to filled
        cellToChange.setSymbol(currentPlayer.getSymbol());
        // we change the sybmol of that cell
        move.setPlayer(currentPlayer);
        // we also set player in the move object becuase while bot we will need this
        move.setCell(cellToChange);
        // then in move object we the cell the update we made
        moveList.add(move);
        // last we add this move object to move list

        nextPlayerIndex++;
        nextPlayerIndex %= playersList.size();

        // now we need to check the winner also


        if(checkWinner(move)){
            setWinner(currentPlayer);
            setGameState(GameState.SUCCESS);
        } else if (moveList.size() == board.getSize()* board.getSize()) {
            setWinner(null);
            setGameState(GameState.DRAW);
            
        }


    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private int size;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public int getSize() {
            return size;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        private void validate(){
            if(players.size() != size-1){
                throw new RuntimeException("Insufficent Player !");
            }

            Set<Character> symbolSet = new HashSet<>();
            for(Player player : players){
                if(symbolSet.contains(player.getSymbol().getSymbol())){
                    throw new RuntimeException("Player have same symbol");
                }
                symbolSet.add(player.getSymbol().getSymbol());
            }

            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }

            if (botCount >1){
                throw new RuntimeException("More than one bot is not allowed");
            }
        }
        public Game Build(){
            validate();
            return new Game(this);
        }
    }
}
/*

Now let's dicuss what should be inside our Game constructor to start a what do we required we need a size of board
and n-1 player , and we should have winningStratgy but if we directly create a construcutre like this Game(size, player , strategy)
prblem with this design we should only create a valid Game object a game object is valid when we have board size and size-1 players
and winningStrategy when all this true then we should create game object to achieve this we will use builder pattern


what we did here was we simply create Builder inner class as static , we wrote static method getBuilder in Game in class
when client will call getBuilder it will get Builder of game class , we write innner builder with all required field to create
game object which is dimension , player list and winningStrategies we also expose the setter to set these field we can set
as time we want once done we call the build methog which is return in builde class and pass the Builder object as to Game
constructor we will only pass the builder object to game when the valudate function run succesfully


 */





