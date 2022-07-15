package mvp.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mvp.dao.StorageDao;
import mvp.model.GameResult;
import mvp.model.Player;
import mvp.validators.BasketballFormatValidator;

public class BasketballGameService implements GameService {
    private static final int NAME_POSITION = 0;
    private static final int NICKNAME_POSITION = 1;
    private static final int NUMBER_POSITION = 2;
    private static final int TEAM_POSITION = 3;
    private static final int SCORED_POSITION = 4;
    private static final int REBOUND_POSITION = 5;
    private static final int ASSIST_POSITION = 6;

    private final StorageDao storageDao;

    public BasketballGameService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void process(GameResult game) {
        BasketballFormatValidator.validate(game);
        Map<Player, Integer> gameResult = new HashMap<>();
        Player mvp = null;
        String[] mvpResult = null;
        int scoreMvp = 0;

        List<String[]> playerStats = game.getPlayerResults().stream()
                .map(r -> r.split(";"))
                .toList();
        String winningTeam = getWinning(playerStats);

        for (String[] playerStat : playerStats) {
            Player player = new Player(playerStat[NAME_POSITION],
                    playerStat[NICKNAME_POSITION],
                    Integer.parseInt(playerStat[NUMBER_POSITION]));
            int score = calculateScore(playerStat);
            gameResult.put(player, score);
            if (score > scoreMvp) {
                scoreMvp = score;
                mvp = player;
                mvpResult = playerStat;
            }
        }

        if (winningTeam.equals(mvpResult[TEAM_POSITION])) {
            gameResult.replace(mvp, gameResult.get(mvp) + 10);
        }
        for (Map.Entry<Player, Integer> entry : gameResult.entrySet()) {
            storageDao.add(entry.getKey(), entry.getValue());
        }
    }

    private int calculateScore(String[] playerStat) {
        return Integer.parseInt(playerStat[SCORED_POSITION]) * 2
                + Integer.parseInt(playerStat[REBOUND_POSITION])
                + Integer.parseInt(playerStat[ASSIST_POSITION]);
    }

    private String getWinning(List<String[]> playerStats) {
        String winningTeam = null;
        int score = 0;
        Map<String, Integer> match = new HashMap<>();
        playerStats.forEach(e -> match.put(e[TEAM_POSITION],
                (match.get(e[TEAM_POSITION]) == null ? 0 : match.get(e[TEAM_POSITION]))
                        + Integer.parseInt(e[SCORED_POSITION])));

        for (Map.Entry<String, Integer> entry : match.entrySet()) {
            if (entry.getValue() > score) {
                winningTeam = entry.getKey();
            }
        }
        return winningTeam;
    }

}
