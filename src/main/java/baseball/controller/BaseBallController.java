package baseball.controller;

import baseball.model.Computer;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallController {

    private final View view;
    private final Computer computer;

    public BaseBallController(View view, Computer computer) {
        this.view = view;
        this.computer = computer;
    }

    public void run() {

        view.startGame();
        System.out.println(computer.getRandomNumbers().toString());
        while (true) {
            while (true) {
                view.readPlayerNumbers();
                String playerNumbers = Console.readLine();

                List<Integer> player = convertPlayerNumbersToIntegers(playerNumbers);
                GameResult gameResult = evaluate(computer.getRandomNumbers(), player);

                String resultMessage = parseResultMessage(gameResult.strike(),gameResult.ball());
                view.printResultMessage(resultMessage);

                if (gameResult.strike() == 3) {
                  break;
                }
            }
            view.printSuccessMessage();
            view.askRestartGame();

            int restartChoice = Integer.parseInt(Console.readLine());

            if (restartChoice == 2) {
                return;
            }
            computer.shuffle();
        }
    }

    private String parseResultMessage(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
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

}
