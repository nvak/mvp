package mvp.strategy;

import mvp.model.GameResult;

public interface GameService {
    void process(GameResult game);
}
