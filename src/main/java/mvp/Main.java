package mvp;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mvp.dao.StorageDao;
import mvp.dao.StorageDaoImpl;
import mvp.mapper.GameMapper;
import mvp.model.Game;
import mvp.model.GameResult;
import mvp.service.FileReaderService;
import mvp.service.ReportService;
import mvp.service.impl.FileReaderServiceImpl;
import mvp.service.impl.ReportServiceImpl;
import mvp.strategy.BasketballGameService;
import mvp.strategy.GameService;
import mvp.strategy.HandballGameService;
import mvp.util.FileScanner;

public class Main {
    private static final String FILES_PATH = "src/main/resources/";


    public static void main(String[] args) {
        List<String> filesList = FileScanner.scan(FILES_PATH);
        //TODO validate

        StorageDao storageDao = new StorageDaoImpl();
        Map<Game, GameService> handleMap = new HashMap<>();
        handleMap.put(Game.BASKETBALL, new BasketballGameService(storageDao));
        handleMap.put(Game.HANDBALL, new HandballGameService(storageDao));

        List<GameResult> games = new ArrayList<>();
        GameMapper gameMapper = new GameMapper();

        for (String file : filesList) {
            FileReaderService reader = new FileReaderServiceImpl();
            List<String> gameResult = reader.read(Path.of(FILES_PATH + file));
            games.add(gameMapper.toGameResult(gameResult));
        }
        for (GameResult game : games) {
            handleMap.get(game.getGame()).process(game);
        }

        ReportService reportService = new ReportServiceImpl(storageDao);
        System.out.println(reportService.report());
    }
}