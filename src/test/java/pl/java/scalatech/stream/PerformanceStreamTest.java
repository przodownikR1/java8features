package pl.java.scalatech.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import com.google.common.base.Stopwatch;

@Slf4j
public class PerformanceStreamTest {
    @Test
    public void parallelTest() {
        Stopwatch sw = Stopwatch.createStarted();

        List<Long> list = new ArrayList<>(10_000_000);
        for (int i = 0; i < 10_000_000; i++) {
            list.add(ThreadLocalRandom.current().nextLong());
        }
        sw.stop();
        log.info("+++ parallelTest  {}", sw.elapsed(TimeUnit.MILLISECONDS));

    }

    @Test
    public void parallelTest2() {
        Stopwatch sw = Stopwatch.createStarted();

        Stream<Long> stream = Stream.generate(() -> ThreadLocalRandom.current().nextLong());
        List<Long> list = stream.limit(10_000_000).collect(Collectors.toList());
        sw.stop();
        log.info("+++ parallelTest2  {}", sw.elapsed(TimeUnit.MILLISECONDS));

    }

    @Test
    public void parallelTest3() {
        Stopwatch sw = Stopwatch.createStarted();

        Stream<Long> stream = ThreadLocalRandom.current().longs(10_000_000).mapToObj(Long::new);
        List<Long> list = stream.collect(Collectors.toList());
        sw.stop();
        log.info("+++ parallelTest3  {}", sw.elapsed(TimeUnit.MILLISECONDS));

    }

}
