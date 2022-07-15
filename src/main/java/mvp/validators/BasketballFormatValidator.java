package mvp.validators;

import java.util.List;
import mvp.exception.DataFormatException;
import mvp.model.GameResult;

public class BasketballFormatValidator {
    public static void validate(GameResult game) {
        String pattern = "[a-zA-Z]+;[a-zA-Z\\d]+;\\d+;[a-zA-Z\\d ]+;\\d+;\\d+;\\d";
        List<String> playerResults = game.getPlayerResults();
        for (String result : playerResults) {
            if (!result.matches(pattern)) {
                throw new DataFormatException("Invalid data format in basketball file");
            }
        }
    }
}
