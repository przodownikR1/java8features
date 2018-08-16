package pl.java.scalatech.functions;

import java.util.function.Function;

import org.assertj.core.api.StrictAssertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComposeTest {
    interface CompositionFunction<T, R> {
        R call(T x);
    }

    public static <T, U, R> CompositionFunction<T, R> compose(final CompositionFunction<U, R> f, final CompositionFunction<T, U> g) {
        return x -> f.call(g.call(x));
    }

    CompositionFunction<Double, Double> doubleNumber = x -> 2 * x;

    @Test
    public void test() {
        log.info("{}", doubleNumber.call(10d));
    }

    @Test
    public void test2() {
        Function<Double, Double> doubleFunction = x -> {
            log.info("doubleFunction before {} ", x);
            x = 2 * x;
            return x;
        };
        Function<Double, Double> second = doubleFunction.compose(x -> {
            x = -x;
            log.info("second {}", x);
            return x;
        });
        log.info("test2 {}", second.apply(10d));
    }

    @Test
    public void andThenTest() {
        Function<Integer, Integer> baseFunction = t -> t + 2;
        Function<Integer, Integer> afterFunction = baseFunction.andThen(t -> t * 3);
        StrictAssertions.assertThat(afterFunction.apply(5)).isEqualTo(21);
    }

    @Test
    public void composeTest() {
        Function<Integer, Integer> baseFunction = t -> t + 2;
        Function<Integer, Integer> beforeFunction = baseFunction.compose(t -> t * 3);
        StrictAssertions.assertThat(beforeFunction.apply(5)).isEqualTo(17);
    }

}
