package mvp.mapper;

import java.util.List;
import mvp.model.Game;
import mvp.model.GameResult;

public class GameMapper {
    public GameResult toGameResult(List<String> gameResult) {
        GameResult result = new GameResult();
        result.setGame(Game.valueOf(gameResult.get(0)));
        gameResult.remove(0);
        result.setPlayerResults(gameResult);
        return result;
    }
}
