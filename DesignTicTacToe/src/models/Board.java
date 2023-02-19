package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;

        board = new ArrayList<>();

        for(int i=0;i<dimension;i++) {
            board.add(new ArrayList<>());
            for(int j=0; j<dimension; j++) {
               board.get(i).add(new Cell());
           }
        }
    }

    Cell getCell(int i,int j) {
        return board.get(i).get(j);
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public int getDimension() {
        return this.dimension;
    }

    public void printBoard() {
        for(List<Cell> row: board) {
            for(Cell cell : row) {
                if (cell.getSymbol() == null) {
                    System.out.print("|   |");
                } else {
                    System.out.printf("| " + cell.getSymbol().getaChar() + " |");
                }
            }
            System.out.printf("\n");
        }
    }
}
