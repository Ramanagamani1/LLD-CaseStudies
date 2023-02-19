package models;

import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(Symbol symbol) {
        super(symbol,PlayerType.HUMAN);
    }

    @Override
    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tell row number starting from 1");
        int row = scanner.nextInt();

        System.out.println("Tell col number where you want to make the move from 1");
        int col = scanner.nextInt();

        Move move = new Move();
        move.setCell(board.getCell(row-1,col-1));
        move.setPlayer(this);
        move.setSymbol(this.getSymbol());
        return move;
    }
}
