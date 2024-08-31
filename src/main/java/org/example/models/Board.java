package org.example.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class Board {
    int dimension;
    List<List<Cell>> board;
    public Board(int dimension){
        this.dimension=dimension;
        board=new ArrayList<>();
        for(int i=0;i<dimension;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<dimension;j++){
                board.get(i).add(new Cell(i,j,CellState.EMPTY));
            }
        }
    }

    //Display the whole board
    public void displayBoard(){
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                if(board.get(i).get(j).getCellState()==CellState.FILLED)
                    System.out.print("| "+board.get(i).get(j).getPlayer().getSymbol()+" |");
                else
                    System.out.print("| |");
            }
            System.out.println();
        }
    }

}
