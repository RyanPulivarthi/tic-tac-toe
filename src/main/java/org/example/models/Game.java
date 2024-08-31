package org.example.models;

import lombok.Data;
import org.example.Exceptions.IlleagalParametersException;
import org.example.WinningStrategy.GameWinningStrategy;
import org.example.WinningStrategy.OrderOneWinningStrategy;

import java.util.List;
import java.util.Scanner;

@Data
public class Game {
    private Board board;
    private Player winner;
    private int nextPlayerIndex;
    List<Player> players;
    private GameState gameState;
    Scanner scan=new Scanner(System.in);
    GameWinningStrategy gameWinningStrategy;
    public Game(int dimension,List<Player> players){
        this.board=new Board(dimension);
        this.players=players;
        this.gameState=GameState.IN_PROGRESS;
        gameWinningStrategy=new OrderOneWinningStrategy(dimension);
    }
    public void makeMove(){
        Player playerToMove=players.get(nextPlayerIndex);
        System.out.println("It's "+playerToMove.getName()+"'s turn");
        System.out.println("Enter row: ");
        int row=scan.nextInt();
        System.out.println("Enter col: ");
        int col=scan.nextInt();
        Cell cell=new Cell(row,col,CellState.FILLED,playerToMove);
        Move move=new Move(playerToMove,cell);
        try {
        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.FILLED)) {

                throw new IlleagalParametersException("Enter valid Dimensions");

        }
        board.getBoard().get(row).set(col,cell);
        if(gameWinningStrategy.CheckWinner(board, move)){
            gameState=GameState.ENDED;
            winner=playerToMove;
        }
        nextPlayerIndex=nextPlayerIndex+1;
        nextPlayerIndex=nextPlayerIndex%players.size();
        } catch (IndexOutOfBoundsException | IlleagalParametersException ex) {
            System.out.println("enter good dimensions");
        }
    }
}
