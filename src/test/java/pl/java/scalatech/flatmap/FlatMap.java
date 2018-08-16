package pl.java.scalatech.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlatMap {
    @Test
    public void shouldFlatMapWork() {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        log.info("{}", together);
    }

    @Test
    public void shouldFlatMapWork2() {
        Optional<Integer> maybeA = Optional.of(1);
        Optional<Integer> maybeB = Optional.of(2);
        Optional<Integer> maybeC = Optional.of(3);

        log.info("{}",
                maybeA.flatMap(a -> maybeB.flatMap(b -> maybeC.map(c -> a + b + c))));
    }
}
