package baseball.model;

import baseball.fixture.ComputerFixture;
import baseball.fixture.TestNumberGenerator;
import baseball.generator.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    private Computer computer;
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setup() {
        computer = ComputerFixture.createComputer();
        numberGenerator = new TestNumberGenerator();
    }

    @Test
    void generateRandomNumbers를_호출하면_RandomNumbers가_할당되는지() {
        computer.generateRandomNumbers(numberGenerator);

        assertThat(computer.getRandomNumbers()).isNotNull();
    }

}