package baseball.vo;

public record GameResult(int strike, int ball,String resultMessage) {

    public static GameResult create(int strike, int ball, String resultMessage) {
        validateString(resultMessage);
        return new GameResult(strike, ball, resultMessage);
    }

    private static void validateString(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException("스트라미크 볼 결과문자열이 비어있습니다.");
        }
    }
}
