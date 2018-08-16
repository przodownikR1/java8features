package pl.java.scalatech.language_feature.mutable;

import java.util.stream.LongStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SideEffectTest {
    @Test
    public void test() {
        log.info("{}", sideEffectParallelSum(1000));
        log.info("{}", sideEffectParallelSum(1000));
        log.info("{}", sideEffectParallelSum(1000));
        log.info("{}", sideEffectParallelSum(1000));
    }

    public static long sideEffectParallelSum(long n) {
        // that multiple threads are concurrently accessing the accumulator and in particular executing total += value , which,
        // despite its appearance, isn’t an atomic operation
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

}

class Accumulator {
    public long total = 0;

    public void add(long value) {
        total += value;
    }
}