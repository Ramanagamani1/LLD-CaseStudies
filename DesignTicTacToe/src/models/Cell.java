package models;

public class Cell {
    private int row;
    private int col;
    private Symbol symbol;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void clearCell() {
        this.symbol = null;
    }

    public boolean isEmpty() {
        return symbol == null;
    }
}
