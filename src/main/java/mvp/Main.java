package mvp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mvp.dao.StorageDao;
import mvp.dao.StorageDaoImpl;
import mvp.model.Game;
import mvp.model.GameResult;
import mvp.service.ReportService;
import mvp.service.impl.ReportServiceImpl;
import mvp.strategy.BasketballGameService;
import mvp.strategy.GameService;
import mvp.strategy.HandballGameService;
import mvp.util.FileReader;
import mvp.util.FileScanner;
import mvp.validators.FileFormatValidator;

public class Main {
    private static final String FILES_PATH = "src/main/resources/";

    public static void main(String[] args) {
        List<String> filesList = FileScanner.scan(FILES_PATH);
        FileFormatValidator.validate(filesList);

        StorageDao storageDao = new StorageDaoImpl();
        Map<Game, GameService> handleMap = new HashMap<>();
        handleMap.put(Game.BASKETBALL, new BasketballGameService(storageDao));
        handleMap.put(Game.HANDBALL, new HandballGameService(storageDao));

        List<GameResult> games = FileReader.toGames(FILES_PATH, filesList);

        for (GameResult game : games) {
            handleMap.get(game.getGame()).process(game);
        }
        ReportService reportService = new ReportServiceImpl(storageDao);
        System.out.println(reportService.report());
    }
}
