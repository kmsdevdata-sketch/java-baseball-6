package baseball.vo;

import baseball.validator.Validator;

import java.util.List;

public record RandomNumbers(List<Integer> randomNumbers) {
    public static RandomNumbers create(List<Integer> randomNumbers) {
        Validator.validateNoDuplicates(randomNumbers);
        return new RandomNumbers(randomNumbers);
    }
}
