package TicTacToe.models;

import java.util.Scanner;

public abstract class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType PlayerType;
    private Scanner scn = new Scanner(System.in);

    public Player (int id,String name,Symbol symbol,PlayerType PlayerType){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.PlayerType = PlayerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return PlayerType;
    }

    public void setPlayerType(PlayerType PlayerType) {
        this.PlayerType = PlayerType;
    }

    public Move makeMove(Board board){
        // so player to makeMove player will need the board on board player will make the move right
        System.out.println("Please enter the row number in which you wish to make a move");
        int row = scn.nextInt();
        System.out.println("Please enter the col number in which you wish to make a move");
        int col = scn.nextInt();

        return new Move(new Cell(row,col),this);


        /*
        what we are doing here is , we wrote an default makeMove function which will run for playertype human
        for bot player we will override it here we take row and col where player wish to make move then we create
        move object inside this we have cell object which stores the row and col where player wish to make move and
        move object also has info but player object that which player made the move
         */

    }
}
