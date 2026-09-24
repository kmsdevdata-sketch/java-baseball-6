package baseball.fixture;

import baseball.model.Player;

import java.util.List;

public class PlayerFixture {

    private static final String USER_INPUT = "123";

    public static Player createPlayer() {
        return Player.create(USER_INPUT);
    }
}
