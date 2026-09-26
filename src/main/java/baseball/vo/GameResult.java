package baseball.vo;

public record GameResult(int strike, int ball,String resultMessage) {

    public static GameResult create(int strike, int ball, String resultMessage) {
        validateStrike(strike);
        validateBall(ball);
        validateString(resultMessage);
        return new GameResult(strike, ball, resultMessage);
    }

    private static void validateStrike(int strike) {
        if (strike < 0 || strike > 3) {
            throw new IllegalArgumentException("스트라이크 갯수가 정상범위에 벗어납니다.");
        }
    }

    private static void validateBall(int ball) {
        if (ball < 0 || ball > 3) {
            throw new IllegalArgumentException("볼 갯수가 정상범위에 벗어납니다.");
        }
    }

    private static void validateString(String resultMessage) {
        if (resultMessage == null || resultMessage.isBlank()) {
            throw new IllegalArgumentException("스트라미크 볼 결과문자열이 비어있습니다.");
        }
    }
}
