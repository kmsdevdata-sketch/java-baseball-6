package baseball;

import baseball.controller.BaseBallController;
import baseball.model.Computer;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {

        View view = new View();
        Computer computer = new Computer();

        BaseBallController baseBallController = new BaseBallController(view,computer);

        baseBallController.run();
    }
}
