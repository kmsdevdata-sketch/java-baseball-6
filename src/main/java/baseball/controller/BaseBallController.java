package baseball.controller;

import baseball.generator.NumberGenerator;
import baseball.generator.RandomNumberGenerator;
import baseball.model.Computer;
import baseball.model.Judge;
import baseball.model.Player;
import baseball.validator.Validator;
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
            NumberGenerator numberGenerator = new RandomNumberGenerator();
            computer.generateRandomNumbers(numberGenerator);
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
        Validator.validateRestartNumber(restartChoice);
        return restartChoice.equals(RESTART);
    }

}
