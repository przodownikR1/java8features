package pl.java.scalatech.concurrent;

import java.util.function.Function;

import org.junit.Test;

public class ParallelTest {
    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest)
                fastest = duration;
        }
        return fastest;
    }

    @Test
    public void testAdder() {
        System.out.println("Iterative sum done in: " + measureSumPerf(ParallelStreams::iterativeSum, 10_000_000) + " msecs");
        System.out.println("Sequential sum done in: " + measureSumPerf(ParallelStreams::sequentialSum, 10_000_000) + " msecs");
        System.out.println("Parallel sum done in: " + measureSumPerf(ParallelStreams::parallelSum, 10_000_000) + " msecs");
        System.out.println("Sequential sum done with Iterate in: " + measureSumPerf(ParallelStreams::sequentialSumInPrimitiveIterate, 10_000_000) + " msecs");
        System.out.println("Parallel sum done with Iterate in: " + measureSumPerf(ParallelStreams::parallelSumInPrimitiveWithIterate, 10_000_000) + " msecs");
        System.out.println(
                "Sequential sum done with RangeClosed in: " + measureSumPerf(ParallelStreams::sequentialSumInPrimitiveRangeClosed, 10_000_000) + " msecs");
        System.out
                .println("Parallel sum done with RangeClosed in: " + measureSumPerf(ParallelStreams::parallelSumInPrimitiveRangeClosed, 10_000_000) + " msecs");
    }
}
