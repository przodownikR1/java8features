package pl.java.scalatech.referenceType;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.util.Lists.newArrayList;
import static pl.java.scalatech.referenceType.StaticReference.Square.findSquareRoot;

import java.util.List;
import java.util.function.Function;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticReference {
    @Test
    public void shouldSquareCalculate() {
        List<Integer> numbers = newArrayList(4, 9, 25);
        List<Double> squares = findSquareRoot(numbers, Math::sqrt);
        log.info("{}", squares);
    }

    static class Square {
        public static List<Double> findSquareRoot(List<Integer> list, Function<Integer, Double> f) {
            return list.stream().map(f).collect(toList());
        }
    }
}