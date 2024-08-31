package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cell {
    int row;
    int col;
    CellState cellState;
    Player player;
    public Cell(int row,int col,CellState cellState){
      this.row=row;
      this.col=col;
      this.cellState=cellState;
    }
}
