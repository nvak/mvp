package mvp.model;

import java.util.Objects;

public final class Player {
    private final String name;
    private final String nickname;
    private final int number;

    public Player(String name, String nickname, int number) {
        this.name = name;
        this.nickname = nickname;
        this.number = number;
    }

    public String name() {
        return name;
    }

    public String nickname() {
        return nickname;
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Player) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.nickname, that.nickname) &&
                this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickname, number);
    }

    @Override
    public String toString() {
        return "Player[" +
                "name=" + name + ", " +
                "nickname=" + nickname + ", " +
                "number=" + number + ']';
    }

}
