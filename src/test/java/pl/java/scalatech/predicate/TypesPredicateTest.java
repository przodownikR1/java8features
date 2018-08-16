package pl.java.scalatech.predicate;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.IntStream.rangeClosed;

import java.util.Random;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import org.assertj.core.api.StrictAssertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TypesPredicateTest {

    @Test
    public void shouldCreateIntSteamAndPredicateOnEvenValue() {
        IntStream stream = newArrayList(1, 2, 3, 4, 5, 6).stream().mapToInt(Integer::intValue);

        IntPredicate evenNumbers = (int i) -> i % 2 == 0;  // no boxing
        StrictAssertions.assertThat(stream.filter(evenNumbers).peek(t -> log.info("{}", t)).count()).isEqualTo(3);

    }

    @Test
    public void rangeAndFilterSum() {
        IntPredicate evenNumbers = (int i) -> i % 5 == 0;
        StrictAssertions.assertThat(rangeClosed(1, 10).filter(evenNumbers).sum()).isEqualTo(15);
    }

    @Test
    public void rangeAndRandomUseLimitToCloseStream() {
        new Random().ints(0, 100).limit(10).forEach(i -> log.info("{}", i));
    }

}
