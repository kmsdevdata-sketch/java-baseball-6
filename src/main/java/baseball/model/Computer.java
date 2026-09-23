package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNumbers = new ArrayList<>();

    public void generateRandomNumbers(){

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        this.randomNumbers = randomNumbers;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
