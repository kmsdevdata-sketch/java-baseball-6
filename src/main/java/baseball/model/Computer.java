package baseball.model;

import baseball.vo.RandomNumbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int RANDOM_RANGE_MIN_NUM = 1;
    private static final int RANDOM_RANGE_MAX_NUM = 9;
    private static final int RANDOM_NUMBERS_RANGE = 3;

    private RandomNumbers randomNumbers;

    public void generateRandomNumbers(){

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < RANDOM_NUMBERS_RANGE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_RANGE_MIN_NUM, RANDOM_RANGE_MAX_NUM);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        this.randomNumbers = RandomNumbers.create(randomNumbers);
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers.randomNumbers();
    }
}
