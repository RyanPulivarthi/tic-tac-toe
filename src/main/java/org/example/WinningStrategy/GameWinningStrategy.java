package org.example.WinningStrategy;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Player;

public interface GameWinningStrategy {
    public boolean CheckWinner(Board board, Move move);
}
