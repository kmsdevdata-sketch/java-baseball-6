package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judge;
import baseball.validator.Validator;
import baseball.view.View;
import baseball.vo.GameResult;

import java.util.ArrayList;
import java.util.List;

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
            String playerNumbers = View.readPlayerNumbers();
            Validator.validatePlayerNumbers(playerNumbers);

            List<Integer> player = convertPlayerNumbersToIntegers(playerNumbers);

            GameResult gameResult = judge.evaluate(computer.getRandomNumbers(), player);
            String resultMessage = judge.parseResultMessage(gameResult.strike(),gameResult.ball());

            View.printResultMessage(resultMessage);

            if (gameResult.strike() == 3) {
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

    private List<Integer> convertPlayerNumbersToIntegers(String playerNumbers) {
        List<Integer> player = new ArrayList<>();
        for (char number : playerNumbers.toCharArray()) {
            player.add(number - '0');
        }
        return player;
    }

}
