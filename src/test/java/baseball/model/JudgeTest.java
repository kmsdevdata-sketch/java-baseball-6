package baseball.model;

import baseball.fixture.ComputerFixture;
import baseball.fixture.PlayerFixture;
import baseball.fixture.TestNumberGenerator;
import baseball.generator.NumberGenerator;
import baseball.vo.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class JudgeTest {

    private Judge judge;
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setup() {
        judge = new Judge();
        numberGenerator = new TestNumberGenerator();
    }

    @Test
    void judge가_입력값에_맞게_GameResult를_생성하는지() {
        Computer computer = ComputerFixture.createComputer();
        computer.generateRandomNumbers(numberGenerator);

        Player player = PlayerFixture.createPlayer();

        GameResult gameResult = judge.judge(computer, player);

        assertThat(gameResult.strike()).isEqualTo(1);
        assertThat(gameResult.ball()).isEqualTo(2);
        assertThat(gameResult.resultMessage()).isEqualTo("2볼 1스트라이크");
    }
}