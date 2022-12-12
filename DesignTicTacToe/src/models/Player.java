package models;

public abstract class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    Player(Symbol symbol, PlayerType playerType) {
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }

}
