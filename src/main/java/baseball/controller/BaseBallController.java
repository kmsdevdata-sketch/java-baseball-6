package baseball.controller;

import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallController {

    private final View view;

    public BaseBallController(View view) {
        this.view = view;
    }

    public void run() {

        view.startGame();

        List<Integer> computer = new ArrayList<>();
        generatedRandomNumbers(computer);

        view.readPlayerNumbers();
        String playerNumbers = Console.readLine();

        List<Integer> player = convertPlayerNumbersToIntegers(playerNumbers);

        GameResult gameResult = evaluate(computer, player);
    }

    private GameResult evaluate(List<Integer> computer, List<Integer> player) {
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

        GameResult gameResult = GameResult.create(strike, ball);

        return gameResult;
    }

    private List<Integer> convertPlayerNumbersToIntegers(String playerNumbers) {
        List<Integer> player = new ArrayList<>();
        for (char number : playerNumbers.toCharArray()) {
            player.add(number - '0');
        }
        return player;
    }

    private void generatedRandomNumbers(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
