package pl.java.scalatech.concurrent;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSumInPrimitiveIterate(long n) {
        return LongStream.iterate(1, i -> i + 1).limit(n).sum();
    }

    public static long parallelSumInPrimitiveWithIterate(long n) {
        return LongStream.iterate(1, i -> i + 1).limit(n).parallel().sum();
    }

    public static long sequentialSumInPrimitiveRangeClosed(long n) {
        return LongStream.rangeClosed(1, n).sum();
    }

    public static long parallelSumInPrimitiveRangeClosed(long n) {
        return LongStream.rangeClosed(1, n).parallel().sum();
    }
}