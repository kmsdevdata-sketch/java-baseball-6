package baseball.model;

import baseball.fixture.ComputerFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void generateRandomNumbers를_두번호출하면_서로다른_RandomNumbers가_할당된다() {
        computer.generateRandomNumbers();
        List<Integer> firstRandomNumbers = computer.getRandomNumbers();

        computer.generateRandomNumbers();
        List<Integer> secondRandomNumbers = computer.getRandomNumbers();

        assertThat(firstRandomNumbers).isNotEqualTo(secondRandomNumbers);
    }

}