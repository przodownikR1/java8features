package pl.java.scalatech.perf;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PerformanceStreamTest {
    private List<String> values;

    @Before
    public void setup() {
        int max = 1000000;
        values = Lists.newArrayList();
        for (int i = 0; i < max; i++) {
            values.add(UUID.randomUUID().toString());
        }
    }

    @Test
    public void sequentialSortTest() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        values.stream().sorted().count();

        stopwatch.stop();

        log.info("sequential sort MILLISECONDS:'{}'", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Test
    public void parallelSortTest() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        values.parallelStream().sorted().count();

        stopwatch.stop();

        log.info("parallel sort MILLISECONDS:'{}'", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
