package baseball.vo;


import java.util.List;

public record RandomNumbers(List<Integer> randomNumbers) {
    public static RandomNumbers create(List<Integer> randomNumbers) {
        validateNoDuplicates(randomNumbers);
        return new RandomNumbers(randomNumbers);
    }

    private static void validateNoDuplicates(List<Integer> randomNumbers) {
        if (randomNumbers.size() != randomNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("숫자는 중복될수 없습니다.");
        }
    }
}
