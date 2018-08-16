package pl.java.scalatech.language_feature.memonizer;

import java.util.function.Function;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemonizerTest {
    Function<Integer, Integer> squareFunction = x -> {
        log.info("In function  {}", x);
        return x * x;
    };
    Function<Double, Double> memoizationFunction2 = Memoizer.memoize(x -> 2 * x * x);

    @Test
    public void memoizerTest() {
        Function<Integer, Integer> memoizationFunction = Memoizer.memoize(squareFunction);
        log.info("{}", memoizationFunction.apply(4));
        log.info("{}", memoizationFunction.apply(5));
        log.info("{}", memoizationFunction.apply(5));
        log.info("{}", memoizationFunction.apply(5));
        log.info("{}", memoizationFunction.apply(6));
        log.info("{}", memoizationFunction.apply(6));

        log.info("2 -> {},", memoizationFunction2.apply(4.0));
    }

}
