package pl.java.scalatech.lambda;

import java.util.List;
import java.util.Optional;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/**
 * @author przodownik
 *         Module name : java8features
 *         Creating time : 14 maj 2014
 */
@Slf4j
public class PredicatesTest {
    List<Integer> values = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
    int total = 0;

    @Test
    public void shouldReturnSumWhenvariableIsGreaterThen3AndEven() {
        for (int i : values) {
            if (i > 3 && i % 2 == 0) {
                total += i;
            }
        }
        log.info("total " + total);
    }

    @Test
    public void shouldReturnFirstEvenAndgreaterThen3() {
        int result = 0;
        for (int i : values) {
            if (i > 3 && i % 2 == 0) {
                result = i;
                break;
            }
        }
        log.info("first " + result);
    }

    @Test
    public void shouldReturnFirstEvenAndGreaterThen3() {
        Optional<Integer> result = values.stream().filter(value -> value > 3).filter(value -> value % 2 == 0).map(value -> value * 2).findFirst();
        log.info("{} ", result.get());
        Assertions.assertThat(result.get()).isEqualTo(8);

    }

    @Test
    public void shouldReturnFirstEvenAndGreaterThen3java8Predicate() {
        Optional<Integer> result = values.stream().filter(PredicatesTest::isEven).filter(PredicatesTest::greaterThenThree).map(PredicatesTest::multipleTwo)
                .findFirst();

        Assertions.assertThat(result.get()).isEqualTo(8);
    }

    private static boolean isEven(int number) {
        log.info("isEven {}", number);
        return number % 2 == 0;
    }

    private static boolean greaterThenThree(int number) {
        log.info("greaterThenThree {}", number);
        return number > 3;
    }

    private static int multipleTwo(int number) {
        log.info("doubleTwo {}", number);
        return number * 2;
    }
}
