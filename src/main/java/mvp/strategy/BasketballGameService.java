package mvp.strategy;

import mvp.dao.StorageDao;
import mvp.model.GameResult;

public class BasketballGameService implements GameService {
    private final StorageDao storageDao;

    public BasketballGameService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void process(GameResult game) {

    }
}
