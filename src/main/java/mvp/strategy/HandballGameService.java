package mvp.strategy;

import java.util.List;
import mvp.dao.StorageDao;
import mvp.model.GameResult;

public class HandballGameService implements GameService{
    private final StorageDao storageDao;

    public HandballGameService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }
    @Override
    public void process(GameResult game) {

    }
}
