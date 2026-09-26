package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @Test
    void create_호출시_올바른값을_입력하면_필드초기화가_정상적으로_이루어지는지() {
        Player player = Player.create("123");
        List<Integer> list = List.of(1, 2, 3);

        assertThat(player.getRandomNumbers()).isNotNull();
        assertThat(player.getRandomNumbers()).isEqualTo(list);
    }

    @Test
    void create_호출시_3자리수가_아니면_예외를_던진다() {
        assertThatThrownBy(() -> Player.create("12")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_호출시_정해진_타입_혹은_범위의값이_아니면_예외를_던진다() {
        assertThatThrownBy(() -> Player.create("문자열")).isInstanceOf(IllegalArgumentException.class);
    }
}