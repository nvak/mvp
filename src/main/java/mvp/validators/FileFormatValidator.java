package mvp.validators;

import java.util.List;
import mvp.exception.FileFormatException;

public class FileFormatValidator {
    private static final String CSV_PATTERN = "^\\w+\\.[csv]{3}";

    public static void validate(List<String> filesList) {
        for (String fileName : filesList) {
            if (!fileName.matches(CSV_PATTERN)) {
                throw new FileFormatException("Invalid file name: " + fileName);
            }
        }
    }
}
