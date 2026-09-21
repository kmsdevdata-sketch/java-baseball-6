package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judge;
import baseball.validator.Validator;
import baseball.view.View;
import baseball.vo.GameResult;

import java.util.ArrayList;
import java.util.List;

public class BaseBallController {

    private final View view;
    private final Computer computer;
    private final Judge judge;

    public BaseBallController(View view, Computer computer, Judge judge) {
        this.view = view;
        this.computer = computer;
        this.judge = judge;
    }

    public void startGame() {
        view.startGame();
        do {
            gameProcess();
        } while (wantsToPlayAgain());
    }

    private void gameProcess() {
        while (true) {
            String playerNumbers = view.readPlayerNumbers();
            Validator.validatePlayerNumbers(playerNumbers);

            List<Integer> player = convertPlayerNumbersToIntegers(playerNumbers);

            GameResult gameResult = judge.evaluate(computer.getRandomNumbers(), player);
            String resultMessage = judge.parseResultMessage(gameResult.strike(),gameResult.ball());

            view.printResultMessage(resultMessage);

            if (gameResult.strike() == 3) {
                return;
            }
        }
    }

    private boolean wantsToPlayAgain() {
        int restartChoice = Integer.parseInt(view.askRestartGame());
        Validator.validateRestartNumber(restartChoice);
        if (restartChoice == 1) {
            computer.shuffle();
        }
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
