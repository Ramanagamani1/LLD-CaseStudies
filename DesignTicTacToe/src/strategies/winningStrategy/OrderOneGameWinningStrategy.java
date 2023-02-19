package strategies.winningStrategy;

import models.Board;
import models.Cell;
import models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategy{

    private List<HashMap<Character,Integer>> rowCharCounts;
    private List<HashMap<Character,Integer>> colCharCounts;

    private void initializeCounts(Board board) {
        rowCharCounts = new ArrayList<>();
        colCharCounts = new ArrayList<>();
        for (int i=0;i< board.getDimension(); ++i) {
            rowCharCounts.add(new HashMap<>());
            colCharCounts.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkIfWon(Board board, Player player, Cell moveCell) {
        if (rowCharCounts == null) {
               initializeCounts(board);
        }
        int row = moveCell.getRow();
        int col = moveCell.getCol();

        if (!rowCharCounts.get(row).containsKey(moveCell.getSymbol().getaChar())) {
               rowCharCounts.get(row).put(moveCell.getSymbol().getaChar(),0);
        }

        if(!colCharCounts.get(col).containsKey(moveCell.getSymbol().getaChar())) {
            colCharCounts.get(col).put(moveCell.getSymbol().getaChar(),0);
        }

        rowCharCounts.get(row).put(
                moveCell.getSymbol().getaChar(),
                1 + rowCharCounts.get(row).get(moveCell.getSymbol().getaChar())
        );

        colCharCounts.get(col).put(
                moveCell.getSymbol().getaChar(),
                1 + colCharCounts.get(col).get(moveCell.getSymbol().getaChar())
        );

        if (rowCharCounts.get(row).get(moveCell.getSymbol().getaChar()).equals(board.getDimension())) {
              return true;
        }

        if (colCharCounts.get(col).get(moveCell.getSymbol().getaChar()).equals(board.getDimension())){
            return true;
        }
        return false;
    }
}
