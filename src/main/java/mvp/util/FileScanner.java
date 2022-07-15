package mvp.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileScanner {
    public static List<String> scan(String path) {
        try (Stream<Path> files = Files.list(Path.of(path))) {
            return files.filter(f -> !Files.isDirectory(f))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
