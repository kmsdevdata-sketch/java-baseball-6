package baseball.config;

import baseball.generator.NumberGenerator;
import baseball.generator.RandomNumberGenerator;

public class BaseBallConfig {

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }
}
