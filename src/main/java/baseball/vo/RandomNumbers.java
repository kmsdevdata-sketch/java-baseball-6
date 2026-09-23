package baseball.vo;

import java.util.List;

public record RandomNumbers(List<Integer> randomNumbers) {
    public static RandomNumbers create(List<Integer> randomNumbers) {
        return new RandomNumbers(randomNumbers);
    }
}
