package mvp.model;

public enum Game {
    BASKETBALL("BASKETBALL"),
    HANDBALL("HANDBALL");

    private final String game;

    Game(String game) {
        this.game = game;
    }

    public String getGame() {
        return game;
    }
}
