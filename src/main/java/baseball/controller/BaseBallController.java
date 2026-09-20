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
