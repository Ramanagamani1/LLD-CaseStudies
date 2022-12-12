package strategies.botPlayingStrategy;

import models.Board;

import models.Move;
import models.Player;
import models.Symbol;

public interface BotPlayingStrategy {
    Move makeNextMove(Board board, Player player);
}
