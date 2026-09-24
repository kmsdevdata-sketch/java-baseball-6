package baseball.model;

import baseball.fixture.ComputerFixture;
import baseball.fixture.PlayerFixture;
import baseball.vo.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {

    private Judge judge;

    @BeforeEach
    void setup() {
        judge = new Judge();
    }

    @Test
    void judge가_입력값에_맞게_GameResult를_생성하는지() {
        Computer computer = ComputerFixture.createComputer();
        computer.generateRandomNumbers();

        Player player = PlayerFixture.createPlayer();

        GameResult gameResult = judge.judge(computer, player);

        assertThat(gameResult.strike());
    }
}