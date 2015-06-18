package pl.java.scalatech.lambda;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Supplier;
import com.google.common.collect.Lists;

/**
 * @author przodownik
 *         Module name : java8features
 *         Creating time : 14 maj 2014
 *         x -> x+1
 *         ()->42
 *         () -> {return 42}
 *         (x,y) -> {}
 *         () -> {}
 */
@Slf4j
public class LambdaTest {
    private List<Integer> values = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

    int total = 0;

    @Test
    public void lambdaFirst() {
        Supplier<String> supplier1 = () -> "Hello";
        Assertions.assertThat(supplier1).isEqualTo("Hello");

    }

    @Test
    public void predicateTest() {
        Predicate<Double> p = x -> x > 2;
        Predicate<Double> p2 = x -> x < 4;
        Assertions.assertThat(p.test(1d)).isFalse();
        assertThat(p2.test(1d)).isTrue();

    }

    @Test
    @Ignore
    public void shouldItegateListOfInteger() {

        for (int l : values) {
            total += l;
            log.info("traditional way :   {} ", l);
        }
        log.info("total   : {}  ", total);
    }

    @Test
    public void shouldItegateListOfIntegerJava8Way() {
        values.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                log.info(" java 8 forEach   :    {}", t);
                total += t;
            }
        });
        log.info("total   : {}  ", total);
    }

    @Test
    public void shouldItegateListOfIntegerJava8BetterWay() {
        values.forEach((Integer i) -> log.info("java 8 way  :   {}", i));
    }

    @Test
    public void shouldItegateListOfIntegerJava8BestWay() {
        values.forEach((value) -> log.info("java 8 better way  :   {}", value));
    }

    @Test
    public void shouldItegateListOfIntegerJava8ShortestWay() {
        values.forEach(System.out::println);
    }

}