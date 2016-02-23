package pl.java.scalatech.functions;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.DataPrepareTest;

@Slf4j
public class ProcessingFunctionTest extends DataPrepareTest {

    Function<String, String> low = t -> t.toLowerCase();
    Function<String, String> up = t -> t.toUpperCase();
    Function<String, String> result = low.andThen(up);

    static BiFunction<String, Integer, String> cut = new BiFunction<String, Integer, String>() {
        @Override
        public String apply(String t, Integer u) {
            return t.substring(0, u);
        }
    };
    List<String> numberString = Lists.newArrayList("34", "3", "5", "11");
    List<Integer> numbers = new ArrayList<>();
    Function<List<String>, List<Integer>> singleFunction = s -> {
        s.stream().forEach(t -> numbers.add(parseInt(t)));
        return numbers;
    };

    {
        log.info(" {}  ", singleFunction.apply(numberString));
        log.info(" second approach {}", numberString.stream().map(Integer::parseInt).collect(toList()));
    }

    @Test
    public void shouldsumElementInArray() {
        int hours[] = { 8, 1, 2, 3 };
        int total = Arrays.stream(hours).sum();
        Assertions.assertThat(total).isEqualTo(14);
    }

    @Test
    public void firstApproach() {
        X1.check(names, String::toUpperCase);
    }

    @Test
    public void biAndThenFunctionApproach() {
        X1.check(names, x -> cut.andThen(up).apply(x, 3));
    }
}

@Slf4j
class X1 {
    public static void checkOld(List<String> strs) {
        for (String element : strs) {
            log.info("{}", strs);
        }
    }

    public static void check(List<String> strs, Function<String, String> f) {
        for (String element : strs) {
            log.info("{}", f.apply(element));
        }
    }

    public static String processString(Function<String, String> operation, String target) {
        return operation.apply(target);
    }
}