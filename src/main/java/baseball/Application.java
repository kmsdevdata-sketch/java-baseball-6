package baseball;

import baseball.controller.BaseBallController;
import baseball.model.Computer;
import baseball.model.Judge;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {

        Computer computer = new Computer();
        Judge judge = new Judge();

        BaseBallController baseBallController = new BaseBallController(computer,judge);

        baseBallController.startGame();
    }
}
