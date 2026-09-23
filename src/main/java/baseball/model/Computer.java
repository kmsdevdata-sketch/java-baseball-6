package baseball.model;

import baseball.vo.RandomNumbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private RandomNumbers randomNumbers;

    public void generateRandomNumbers(){

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        this.randomNumbers = RandomNumbers.create(randomNumbers);
    }

    public RandomNumbers getRandomNumbers() {
        return randomNumbers;
    }
}
