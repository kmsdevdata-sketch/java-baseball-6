package baseball.fixture;

import baseball.generator.NumberGenerator;
import baseball.model.Computer;

public class ComputerFixture {

    public static Computer createComputer() {
        NumberGenerator numberGenerator = new TestNumberGenerator();
        return new Computer(numberGenerator);
    }
}
