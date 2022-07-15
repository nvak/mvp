package mvp.util;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import mvp.exception.DataFormatException;
import mvp.mapper.GameMapper;
import mvp.model.GameResult;
import mvp.service.FileReaderService;
import mvp.service.impl.FileReaderServiceImpl;

public class FileReader {
    public static List<GameResult> toGames(String path, List<String> filesList) {
        List<GameResult> games = new ArrayList<>();
        for (String file : filesList) {
            GameMapper gameMapper = new GameMapper();
            FileReaderService reader = new FileReaderServiceImpl();
            List<String> gameResult = reader.read(Path.of(path + file));
            if (gameResult.size() == 0) {
                throw new DataFormatException("File is empty: " + file);
            }
            games.add(gameMapper.toGameResult(gameResult));
        }
        return games;
    }
}
