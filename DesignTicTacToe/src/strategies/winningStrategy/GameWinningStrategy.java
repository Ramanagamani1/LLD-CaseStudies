package strategies.winningStrategy;

import models.Board;
import models.Cell;
import models.Player;


public interface GameWinningStrategy {
    boolean checkIfWin(Board board, Player player);
}
