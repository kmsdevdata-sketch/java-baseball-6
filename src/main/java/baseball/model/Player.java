package baseball.model;

import baseball.validator.Validator;
import baseball.vo.RandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private RandomNumbers randomNumbers;

    private Player(List<Integer> randomNumbers) {
        this.randomNumbers = RandomNumbers.create(randomNumbers);
    }

    public static Player create(String playerNumbers) {
        Validator.validatePlayerNumbers(playerNumbers);
        convertPlayerNumbersToIntegers(playerNumbers);

        return new Player(convertPlayerNumbersToIntegers(playerNumbers));
    }

    private static List<Integer> convertPlayerNumbersToIntegers(String playerNumbers) {
        List<Integer> player = new ArrayList<>();
        for (char number : playerNumbers.toCharArray()) {
            player.add(number - '0');
        }
        return player;
    }
}
