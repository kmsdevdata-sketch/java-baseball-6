package baseball.model;

import baseball.vo.GameResult;

import java.util.List;

public class Judge {

    public GameResult judge(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            int playerNumber = player.get(i);

            if (computer.get(i) == playerNumber) {
                strike++;
            } else if (computer.contains(playerNumber)) {
                ball++;
            }
        }

        return new GameResult(strike, ball, makeCallSign(strike, ball));
    }

    public boolean isOut(GameResult gameResult) {
        return gameResult.strike() == 3;
    }

    private String makeCallSign(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
