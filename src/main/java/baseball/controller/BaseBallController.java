package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judge;
import baseball.model.Player;
import baseball.view.View;
import baseball.vo.GameResult;

public class BaseBallController {

    private static final String RESTART = "1";

    private final Computer computer;
    private final Judge judge;

    public BaseBallController(Computer computer, Judge judge) {
        this.computer = computer;
        this.judge = judge;
    }

    public void startGame() {
        View.startGame();
        do {
            computer.generateRandomNumbers();
            gameProcess();
        } while (wantsToPlayAgain());
    }

    private void gameProcess() {
        while (true) {

            Player player = Player.create(View.readPlayerNumbers());

            GameResult gameResult = judge.judge(computer, player);

            View.printResultMessage(gameResult.resultMessage());

            if (judge.isOut(gameResult)) {
                View.printSuccessMessage();
                return;
            }
        }
    }

    private boolean wantsToPlayAgain() {
        String restartChoice = View.askRestartGame();
        validateRestartNumber(restartChoice);
        return restartChoice.equals(RESTART);
    }

    private void validateRestartNumber(String restartChoice) {
        if (!restartChoice.equals("1") && !restartChoice.equals("2")) {
            throw new IllegalArgumentException("입력값은 1,2중에 선택하여야 합니다.");
        }
    }


}
