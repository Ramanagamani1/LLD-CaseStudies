package models;

import exceptions.MultipleBotsException;
import strategies.winningStrategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameStatus gameStatus;
    private Player winner;
    private int lastMovedPlayerIndex;
    private List<GameWinningStrategy> winningStrategies;

    private Game() {
       this.players = new ArrayList<>();
       this.moves = new ArrayList<>();
       this.winningStrategies = new ArrayList<>();
       this.lastMovedPlayerIndex = -1;
       this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder{
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;
        private int dimension;

        Builder() {
            this.players = new ArrayList<>();
            this.gameWinningStrategies = new ArrayList<>();
        }

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder addPlayers(List<Player> players) {
            this.players.addAll(players);
            return this;
        }

        public Builder addGameWinningStrategy(GameWinningStrategy strategy) {
            this.gameWinningStrategies.add(strategy);
            return this;
        }

        public Builder addGameWinningStrategies(List<GameWinningStrategy> strategies) {
            this.gameWinningStrategies.addAll(strategies);
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public boolean checkIfSingleBotMax() {
            int count = 0;
            for(Player player : players) {
                if(player.getPlayerType().equals(PlayerType.BOT))
                    count+=1;
            }
            return count<=1;
        }


        public Game build() throws MultipleBotsException{
              if(!checkIfSingleBotMax()) {
                    throw new MultipleBotsException();
              }
              if (players.size() < 2) {
                  // throw that players should be atleast 2
              }
              Game game = new Game();
              game.players.addAll(this.players);
              game.winningStrategies.addAll(this.gameWinningStrategies);
              game.board = new Board(dimension);
              return game;
        }


    }


}
