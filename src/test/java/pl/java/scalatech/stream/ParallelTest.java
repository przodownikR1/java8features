package pl.java.scalatech.stream;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParallelTest {

    List<String> strs = newArrayList("slawek", "aga", "kalina", "tomek");
    Consumer<String> c = x -> log.info(" item : {} , thread : {}", x, Thread.currentThread());

    @Test
    public void seqTest() {
        strs.stream().forEach(c);
    }

    @Test
    public void parallelTest() {
        strs.stream().parallel().forEach(c);
    }

}
