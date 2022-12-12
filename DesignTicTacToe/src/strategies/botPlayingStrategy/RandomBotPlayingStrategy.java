package strategies.botPlayingStrategy;

import models.*;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeNextMove(Board board, Player player) {
        for(List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.isEmpty()) {
                      Move move = new Move();
                      move.setSymbol(player.getSymbol());
                      move.setCell(cell);
                      return move;
                }
            }
        }
        return null;
    }
}
