package baseball.model;

import baseball.fixture.ComputerFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setup() {
        computer = ComputerFixture.createComputer();
    }

    @Test
    void generateRandomNumbers를_호출하면_RandomNumbers가_할당되는지() {
        computer.generateRandomNumbers();
        assertThat(computer.getRandomNumbers()).isNotNull();
    }

}