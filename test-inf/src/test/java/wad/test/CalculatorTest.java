package wad.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @DisplayName("두 정수를 add함수를 통해 더할 수 있다.")
    @Test
    void add() {
        // given
        int a = 4;
        int b = 3;
        // when
        int result = calculator.add(a, b);
        // then
        assertThat(result).isEqualTo(a+b+1);
    }

    @DisplayName("두 정수를 나누면 나누어진 실수 값이 반환된다.")
    @Test
    void divide() {
        // given
        int a = 7;
        int b = 4;
        // when
        float result = calculator.divide(a, b);
        // then
        assertThat(result).isEqualTo((float) a/b);
    }

    @DisplayName("divide 함수를 통해 나누려고 했을 때 두번째 인자가 0이면 에러를 발생시킨다.")
    @Test
    void divideWithZero() {
        // given
        int a = 7;
        int b = 0;
        // when & then
        assertThatThrownBy(()-> calculator.divide(a, b))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("나누는 수는 0이 아니어야 합니다.");
    }
}