package mvp.model;

import java.util.List;
import java.util.Objects;

public class GameResult {
    private Game game;
    private List<String> playerResults;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<String> getPlayerResults() {
        return playerResults;
    }

    public void setPlayerResults(List<String> playerResults) {
        this.playerResults = playerResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResult that = (GameResult) o;
        return game == that.game
                && Objects.equals(playerResults, that.playerResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, playerResults);
    }

    @Override
    public String toString() {
        return "GameResult{"
                + "game=" + game
                + ", playerResults=" + playerResults
                + '}';
    }
}
