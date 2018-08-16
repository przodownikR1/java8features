package pl.java.scalatech.exercise;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrimeNumbers {

    public static final int LIMIT = 50;

    @Test
    public void shouldGeneratePrime() {
        log.info("{}", IntStream.rangeClosed(1, LIMIT).parallel().filter(PrimeNumbers::isPrime).boxed().collect(toList()));

    }

    private static boolean isPrime(int n) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }

    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(1, 5, 4);
        Double average = numbers.stream().collect(averagingInt(number -> number));
        Double averageDouble = numbers.stream().collect(averagingDouble(number -> number));
        log.info("averInt {}", average);
        log.info("averDouble {}", averageDouble);

    }

    @Test
    public void test2() {
        log.info("{}", sideEffectConcat(10));
        log.info("{}", parallelConcat(10));
    }

    private static String sideEffectConcat(int n) {
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1, n).parallel().mapToObj(i -> i + " ").forEach(sb::append);
        return sb.toString();
    }

    private static String parallelConcat(int n) {
        return IntStream.rangeClosed(1, n).parallel()
                .mapToObj(i -> i + " ").reduce("", (a, b) -> a + b);
    }

}