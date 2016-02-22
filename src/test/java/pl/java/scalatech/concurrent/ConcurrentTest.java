package pl.java.scalatech.concurrent;

import static java.util.stream.Stream.iterate;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Rule;
import org.junit.Test;

import com.google.common.base.Stopwatch;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.timeTest.Timed;
import pl.java.scalatech.timeTest.TimedTest;

@Slf4j
public class ConcurrentTest {

    @Rule
    public TimedTest timeTest = new TimedTest();

    @Test
    public void calculateConcurrentTest() {
        //iterate generates boxed objects, which have to be unboxed to numbers before they can be added
        //iterate is difficult to divide into independent chunks to execute in parallel .
        
        Stopwatch sw = Stopwatch.createStarted();
        log.info("parallel : {}", parallelSum(10000));
        log.info("parallel : {}", sw.stop().elapsed(TimeUnit.MILLISECONDS));
    }

    @Test
    public void calculateSeqTest() {
        Stopwatch sw = Stopwatch.createStarted();
        log.info("seq : {}", sum(10000));
        log.info("seq : {}", sw.stop().elapsed(TimeUnit.MILLISECONDS));
    }
    
    @Test
    public void calculateParallelSumTest() {
        
        //LongStream.rangeClosed works on primitive long numbers directly so there’s no boxing and unboxing overhead.
        //LongStream.rangeClosed produces ranges of numbers, which can be easily split into independent chunks
        
        Stopwatch sw = Stopwatch.createStarted();
        log.info("parallelSum2 : {}", parallelSum2(10000));
        log.info("parallelSum2: {}", sw.stop().elapsed(TimeUnit.MILLISECONDS));
    }

    public static long parallelSum(long n) {
        return LongStream.iterate(1, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long parallelSum2(long n) {
        return LongStream.rangeClosed(1, n).parallel().sum();
    }

    public static long sum(long n) {
        return LongStream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }
}
