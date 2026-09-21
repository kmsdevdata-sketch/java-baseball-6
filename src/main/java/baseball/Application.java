package baseball;

import baseball.controller.BaseBallController;
import baseball.model.Computer;
import baseball.model.Judge;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {

        View view = new View();
        Computer computer = new Computer();
        Judge judge = new Judge();

        BaseBallController baseBallController = new BaseBallController(view,computer,judge);

        baseBallController.run();
    }
}
