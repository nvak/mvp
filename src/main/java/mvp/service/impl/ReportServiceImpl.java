package mvp.service.impl;

import mvp.dao.StorageDao;
import mvp.model.Player;
import mvp.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private final StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String report() {
        Player mvp = storageDao.getMvp();
        return mvp.toString();
    }
}
