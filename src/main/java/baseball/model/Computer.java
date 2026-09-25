package baseball.model;

import baseball.generator.NumberGenerator;
import baseball.vo.RandomNumbers;

import java.util.List;

public class Computer {

    private RandomNumbers randomNumbers;
    private final NumberGenerator numberGenerator;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void generateRandomNumbers() {
        this.randomNumbers = RandomNumbers.create(numberGenerator.generate());
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers.randomNumbers();
    }
}
