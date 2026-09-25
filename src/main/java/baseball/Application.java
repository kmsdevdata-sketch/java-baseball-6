package baseball;

import baseball.config.BaseBallConfig;
import baseball.controller.BaseBallController;
import baseball.model.Computer;
import baseball.model.Judge;

public class Application {
    public static void main(String[] args) {

        BaseBallConfig baseBallConfig = new BaseBallConfig();
        Computer computer = new Computer(baseBallConfig.numberGenerator());
        Judge judge = new Judge();

        BaseBallController baseBallController = new BaseBallController(computer,judge);

        baseBallController.startGame();
    }
}
