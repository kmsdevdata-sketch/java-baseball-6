package baseball.validator;

import java.util.List;

public class Validator {

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



}
