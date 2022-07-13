package mvp.dao;

import java.util.Map;
import java.util.Set;
import mvp.model.Player;
import mvp.storage.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Player player, int score) {
        Integer currentScore = Storage.playerStorage.get(player);
        if (currentScore == null) {
            Storage.playerStorage.put(player, score);
        } else {
            Storage.playerStorage.replace(player, currentScore + score);
        }
    }

    @Override
    public Player getMvp() {
        Player mvp = null;
        int maxValue = Integer.MIN_VALUE;
        Set<Map.Entry<Player, Integer>> entries = Storage.playerStorage.entrySet();
        for (Map.Entry<Player, Integer> entry : entries) {
            if (entry.getValue() > maxValue) {
                mvp = entry.getKey();
            }
        }
        return mvp;
    }
}
