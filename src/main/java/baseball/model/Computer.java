package baseball.model;

import baseball.generator.NumberGenerator;
import baseball.vo.RandomNumbers;

import java.util.List;

public class Computer {

    private RandomNumbers randomNumbers;

    public void generateRandomNumbers(NumberGenerator numberGenerator) {

        List<Integer> generatedNumbers = numberGenerator.generate();

        this.randomNumbers = RandomNumbers.create(generatedNumbers);
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers.randomNumbers();
    }
}
