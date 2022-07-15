package mvp.validators;

import java.util.List;
import mvp.exception.DataFormatException;
import mvp.model.GameResult;

public class HandballFormatValidator {
    public static void validate(GameResult game) {
        String pattern = "[a-zA-Z]+;[a-zA-Z\\d]+;\\d+;[a-zA-Z\\d ]+;\\d+;\\d+";
        List<String> playerResults = game.getPlayerResults();
        if (playerResults.size() == 0){
            throw new DataFormatException("No data in handball file");
        }
        for (String result : playerResults) {
            if (!result.matches(pattern)) {
                throw new DataFormatException("Invalid data format in handball file");
            }
        }
    }
}
