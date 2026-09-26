package baseball.vo;


import java.util.List;

public record RandomNumbers(List<Integer> randomNumbers) {
    public static RandomNumbers create(List<Integer> randomNumbers) {
        validateNoDuplicates(randomNumbers);
        validateNumberLength(randomNumbers);
        validateNumberRange(randomNumbers);

        return new RandomNumbers(randomNumbers);
    }

    private static void validateNoDuplicates(List<Integer> randomNumbers) {
        if (randomNumbers.size() != randomNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("숫자는 중복될수 없습니다.");
        }
    }

    private static void validateNumberLength(List<Integer> randomNumbers) {
        if (randomNumbers.size() != 3) {
            throw new IllegalArgumentException("입력값은 3자리수 여야 합니다.");
        }
    }

    private static void validateNumberRange(List<Integer> randomNumbers) {
        for (Integer randomNumber : randomNumbers) {
            if (randomNumber < 1 || randomNumber > 9) {
                throw new IllegalArgumentException("입력값은 정수 1~9 사이의 값이여야 합니다.");
            }
        }
    }
}
