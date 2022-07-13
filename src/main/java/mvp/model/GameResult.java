package mvp.model;

import java.util.List;
import lombok.Data;

@Data
public class GameResult {
    private Game game;
    private List<String> playerResults;
}
