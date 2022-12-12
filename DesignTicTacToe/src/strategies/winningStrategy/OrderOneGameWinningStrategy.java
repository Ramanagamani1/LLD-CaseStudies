package strategies.winningStrategy;

import models.Board;
import models.Player;

public class OrderOneGameWinningStrategy implements GameWinningStrategy{

    @Override
    public boolean checkIfWin(Board board, Player player) {
        return false;
    }
}
