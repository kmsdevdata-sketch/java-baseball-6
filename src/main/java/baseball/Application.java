package baseball;

import baseball.controller.BaseBallController;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {

        View view = new View();

        BaseBallController baseBallController = new BaseBallController(view);

        baseBallController.run();
    }
}
