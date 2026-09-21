package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNumbers = new ArrayList<>();

    public Computer() {
        this.randomNumbers = generate();
    }

    private List<Integer> generate(){

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }

    public void shuffle() {
        this.randomNumbers = generate();
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
