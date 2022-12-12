package factories;

import models.BotDifficultyLevel;
import strategies.botPlayingStrategy.BotPlayingStrategy;
import strategies.botPlayingStrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public BotPlayingStrategy createBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
          return switch(botDifficultyLevel) {
              case EASY , MEDIUM, HARD -> new RandomBotPlayingStrategy();
          };
    }
}
