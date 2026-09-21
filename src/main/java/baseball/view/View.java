package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String readPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return readInput();
    }

    public void printResultMessage(String resultMessage) {
        System.out.println(resultMessage);
    }

    public void printSuccessMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String askRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readInput();
    }

    private String readInput() {
        return Console.readLine();
    }

}
