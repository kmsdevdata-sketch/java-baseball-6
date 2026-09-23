package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judge;
import baseball.model.Player;
import baseball.validator.Validator;
import baseball.view.View;
import baseball.vo.GameResult;

public class BaseBallController {

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

            GameResult gameResult = judge.judge(computer.getRandomNumbers(), player.getRandomNumbers());

            View.printResultMessage(gameResult.resultMessage());

            if (judge.isOut(gameResult)) {
                View.printSuccessMessage();
                return;
            }
        }
    }

    private boolean wantsToPlayAgain() {
        int restartChoice = Integer.parseInt(View.askRestartGame());
        Validator.validateRestartNumber(restartChoice);
        return restartChoice == 1;
    }



}
