package baseball.controller;

import baseball.view.View;
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
