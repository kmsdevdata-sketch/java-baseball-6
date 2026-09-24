package baseball.model;

import baseball.vo.RandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private RandomNumbers randomNumbers;

    private Player(List<Integer> randomNumbers) {
        this.randomNumbers = RandomNumbers.create(randomNumbers);
    }

    public static Player create(String playerNumbers) {
        validateNumberLength(playerNumbers);
        validateNumberRange(playerNumbers);

        return new Player(convertPlayerNumbersToIntegers(playerNumbers));
    }

    private static List<Integer> convertPlayerNumbersToIntegers(String playerNumbers) {
        List<Integer> playerList = new ArrayList<>();
        for (char number : playerNumbers.toCharArray()) {
            playerList.add(number - '0');
        }
        return playerList;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers.randomNumbers();
    }

    private static void validateNumberLength(String playerNumbers) {
        if (playerNumbers.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리수 여야 합니다.");
        }
    }

    private static void validateNumberRange(String playerNumbers) {
        for (String number : playerNumbers.split("")) {
            if (!number.matches("[1-9]+")) {
                throw new IllegalArgumentException("입력값은 정수 1~9 사이의 값이여야 합니다.");
            }
        }
    }
}
