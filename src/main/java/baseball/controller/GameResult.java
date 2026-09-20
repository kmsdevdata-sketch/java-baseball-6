package baseball.controller;

public record GameResult(int strike, int ball) {

    public static GameResult create(int strike, int ball) {
        return new GameResult(strike, ball);
    }
}
