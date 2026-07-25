package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class calculatorTest {

    @Test
    void sum_whenEverythingIsOk(){
        var result = Calculator.sum(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void minus_whenEverythingIsOk(){
        var result = Calculator.minus(2, 3);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void isNegative(){
        var result = Calculator.isNegative(-2);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void test_unaryOperator(){
        var result = Calculator.plusFive( 6);
        assertThat(result).isEqualTo(11);
    }
}