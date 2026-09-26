package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator{

    private static final int RANDOM_RANGE_MIN_NUM = 1;
    private static final int RANDOM_RANGE_MAX_NUM = 9;
    private static final int RANDOM_NUMBERS_RANGE = 3;

    @Override
    public List<Integer> generate() {

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < RANDOM_NUMBERS_RANGE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_RANGE_MIN_NUM, RANDOM_RANGE_MAX_NUM);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }
}
