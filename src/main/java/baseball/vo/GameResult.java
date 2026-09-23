package baseball.vo;

public record GameResult(int strike, int ball,String resultMessage) {

    public static GameResult create(int strike, int ball, String resultMessage) {
        return new GameResult(strike, ball, resultMessage);
    }
}
