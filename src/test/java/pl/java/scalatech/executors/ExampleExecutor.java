package pl.java.scalatech.executors;

import static java.lang.System.err;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.stream.IntStream.range;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.Test;

public class ExampleExecutor {
    @Test
    public void test() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            es.submit(() -> System.err.println("run " + index));
            // index = 22;
        }

        System.err.println("task start");
        es.shutdown();
    }

    @Test
    public void test2() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int index = i;
            es.submit(() -> System.err.println("run " + index));
        }

        System.err.println("task start");
        es.shutdown();
    }

    @Test
    public void test3() {

        ExecutorService es = newFixedThreadPool(10);
        range(0, 10).forEach(i -> es.submit(() -> System.err.println("run " + i)));
        err.println("task start");
        es.shutdown();
    }

    @Test
    public void primeTest() {
        for (int i = 0; i < 10; i++) {
            System.err.println(i + " is prime " + isPrime(i));
        }
    }

    @Test
    public void primeTest2() {
        for (int i = 0; i < 10; i++) {
            System.err.println(i + " is prime " + isPrime2(i));
        }
    }

    @Test
    public void iteratorFalseTest() {
        Iterator<String> sourceIterator = Arrays.asList("A", "B", "C").iterator();
        Stream<String> targetStream = Stream.generate(sourceIterator::next);
        targetStream.forEach(System.out::println);
    }

    @Test
    public void interatorTrueTest() {
        Iterator<String> sourceIterator = Arrays.asList("A", "B", "C").iterator();
        Iterable<String> iterable = () -> sourceIterator;
        Stream<String> targetStream = StreamSupport.stream(iterable.spliterator(), false);
        targetStream.forEach(System.out::println);
    }

    public static boolean isPrime(int number) {
        boolean divisable = false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                divisable = true;
                break;
            }
        }
        return number > 1 && !divisable;

    }

    public static boolean isPrime2(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(i -> number % i == 0);

    }

    @Test
    public void streamITest() {
        streamIterator();
    }

    @Test
    public void streamI2Test() {
        streamPrimeIterator();
    }

    public static void streamIterator() {
        Stream.iterate(1, e -> e + 1).limit(100).forEach(i -> System.err.println(i));
    }

    public static void streamPrimeIterator() {
        Stream.iterate(1, e -> e + 1).filter(ExampleExecutor::isPrime2).limit(100).forEach(i -> System.err.println(i));
    }

}
