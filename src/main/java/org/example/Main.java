package org.example;

import org.example.Exceptions.IlleagalParametersException;
import org.example.models.Game;
import org.example.models.GameState;
import org.example.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Hello to the world of tic tac toe");
        System.out.println("Enter the dimensions you want");
        int dimension=scan.nextInt();
        List<Player> players=new ArrayList<>();
        Game game=new Game(dimension,players);
        for(int i=0;i<dimension-1;i++){
            Player player=new Player();
            System.out.println("Enter the name of player "+(i+1)+" : ");
            player.setName(scan.next());
            System.out.println("Enter the symbol of the player : ");
            player.setSymbol(scan.next());
            players.add(player);
        }
        while(game.getGameState()==GameState.IN_PROGRESS){
            System.out.println("This is the current status of the board");
            game.getBoard().displayBoard();
            game.makeMove();
        }
        if(game.getGameState()==GameState.ENDED){
            System.out.println(game.getWinner().getName()+" won the Game");
        }

    }
}