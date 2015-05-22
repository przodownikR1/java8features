package pl.java.scalatech.lambda;

import java.util.List;
import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author przodownik
 * Module name :    java8features
 * Creating time :  14 maj 2014
 * x -> x+1
 */
@Slf4j
public class LambdaTest {
    private List<Integer> values = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

    int total = 0;

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