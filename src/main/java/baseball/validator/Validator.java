package baseball.validator;

import java.util.List;

public class Validator {

    public static void validatePlayerNumbers(String playerNumbers) {
        validateNumberLength(playerNumbers);
        validateNumberRange(playerNumbers);
    }

    public static void validateNoDuplicates(List<Integer> randomNumbers) {
        if (randomNumbers.size() != randomNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("숫자는 중복될수 없습니다.");
        }
    }

    public static void validateRestartNumber(String restartChoice) {
        if (!restartChoice.equals("1") && !restartChoice.equals("2")) {
            throw new IllegalArgumentException("입력값은 1,2중에 선택하여야 합니다.");
        }
    }

    private static void validateNumberLength(String playerNumbers) {
        if (playerNumbers.length() > 3) {
            throw new IllegalArgumentException("입력값은 3자리수 이내여야 합니다.");
        }
    }

    private static void validateNumberRange(String playerNumbers) {
        for (String number : playerNumbers.split("")) {
            if (!number.matches("[1-9]+")) {
                throw new IllegalArgumentException("입력값은 1~9 사이의 값이여야 합니다.");
            }
        }
    }

}
