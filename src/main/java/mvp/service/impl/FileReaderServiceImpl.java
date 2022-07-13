package mvp.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import mvp.service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> read(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("File not found at: " + path, e);
        }
    }
}
