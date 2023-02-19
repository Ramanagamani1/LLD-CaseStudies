package strategies.winningStrategy;

import models.Board;
import models.Cell;
import models.Player;


public interface GameWinningStrategy {
    boolean checkIfWon(Board board, Player player, Cell moveCell);
}
