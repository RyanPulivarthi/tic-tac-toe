package org.example.WinningStrategy;

import org.example.models.Board;
import org.example.models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements GameWinningStrategy{
    int dimension;
    List<HashMap<String,Integer>> rowCount=new ArrayList<>();
    List<HashMap<String,Integer>> colCount=new ArrayList<>();
    HashMap<String,Integer> topLeftCount=new HashMap<>();
    HashMap<String,Integer> topRightCount=new HashMap<>();
    public OrderOneWinningStrategy(int dimension){
        this.dimension=dimension;
        for(int i=0;i<dimension;i++){
            rowCount.add(new HashMap<>());
            colCount.add(new HashMap<>());
        }
    }
    public boolean isCellOnTopLeftDiagonal(int r,int c){
        return r==c;
    }
    public boolean isCellOnTopRightDiagonal(int r,int c){
        return r+c==dimension-1;
    }
    @Override
    public boolean CheckWinner(Board board, Move move) {
        String symbol=move.getPlayer().getSymbol();
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        //Incrementing row hashmap count
        if(!rowCount.get(row).containsKey(symbol))
            rowCount.get(row).put(symbol,1);
        else
            rowCount.get(row).put(symbol,rowCount.get(row).get(symbol)+1);

        //Incrementing Column hashmap count
        if(!colCount.get(col).containsKey(symbol))
            colCount.get(col).put(symbol,1);
        else
            colCount.get(col).put(symbol,colCount.get(col).get(symbol)+1);

        //Incrementing topleft diagonal count
        if(isCellOnTopLeftDiagonal(row,col)) {
            if (!topLeftCount.containsKey(symbol))
                topLeftCount.put(symbol, 1);
            else
                topLeftCount.put(symbol,topLeftCount.get(symbol)+1);
        }

        //Incrementing topright diagonal count
        if(isCellOnTopRightDiagonal(row,col)){
            if(!topRightCount.containsKey(symbol))
                topRightCount.put(symbol,1);
            else
                topRightCount.put(symbol,topRightCount.get(symbol)+1);
        }

        //Checking if winner
        if(rowCount.get(row).get(symbol)==dimension || colCount.get(col).get(symbol)==dimension)
            return true;
        if(isCellOnTopLeftDiagonal(row,col) && topLeftCount.get(symbol)==dimension)
            return true;
        if(isCellOnTopRightDiagonal(row,col) && topRightCount.get(symbol)==dimension)
            return true;




        return false;
    }
}
