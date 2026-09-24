package baseball.fixture;

import baseball.model.Player;

import java.util.List;

public class PlayerFixture {

    public static Player createPlayer(String userInput) {
        return Player.create(userInput);
    }

}
