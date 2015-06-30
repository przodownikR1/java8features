package pl.java.scalatech;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParallelArrayTest {
    @Test
    public void shouldParallelArrayCreateWork() {
        long[] arrayOfLong = new long[1000];

        Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000));
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> log.info("{}", i));
        log.info("+++  {}",Arrays.toString(arrayOfLong));
        log.info("++++ sort");
        Arrays.parallelSort(arrayOfLong);
        log.info("+++  {}",Arrays.toString(arrayOfLong));
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> log.info("{}", i));

    }

}
