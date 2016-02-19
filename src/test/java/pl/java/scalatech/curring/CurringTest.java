package pl.java.scalatech.curring;

import java.util.function.BiFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CurringTest {
    DoubleUnaryOperator convert(double factor, double base) {
        return amount -> amount * factor + base;
    }

    @Test
    public void curringTest() {
        DoubleUnaryOperator currencyDollarToZl = convert(3.2, 0);
        DoubleUnaryOperator kmToMi = convert(0.621, 0);
        DoubleUnaryOperator convertFinal = convert(10, 2);
        log.info(" {}", convertFinal.applyAsDouble(5));
        log.info(" km {}", kmToMi.applyAsDouble(320));
        log.info(" currency {}", currencyDollarToZl.applyAsDouble(11));

    }

    @Test
    public void curring2Test() {
        currying();
    }

    public static void currying() {
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;
        Function<Integer, Function<Integer, Integer>> currier = a -> b -> adder.apply(a, b);
        log.info("currier {}", currier.apply(2).apply(3));
        Function<Integer, Integer> curried = currier.apply(4);
        Assertions.assertThat(curried.apply(3)).isEqualTo(7);

    }

    public static void composition() {

        Function<Integer, Integer> add3 = (a) -> a + 3;

        Function<Integer, Integer> times2 = (a) -> a * 2;

        Function<Integer, Integer> composedA = add3.compose(times2);

        Function<Integer, Integer> composedB = times2.compose(add3);

        Assertions.assertThat(composedA.apply(6)).isEqualTo(15);
        Assertions.assertThat(composedB.apply(6)).isEqualTo(18);

    }
}
