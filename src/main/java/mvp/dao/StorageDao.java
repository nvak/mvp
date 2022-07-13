package mvp.dao;

import mvp.model.Player;

public interface StorageDao {
    void add(Player player,int score);

    Player getMvp();
}
