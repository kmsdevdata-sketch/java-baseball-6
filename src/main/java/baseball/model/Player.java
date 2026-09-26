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
}
