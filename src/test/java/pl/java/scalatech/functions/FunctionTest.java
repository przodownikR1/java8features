package pl.java.scalatech.functions;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class FunctionTest {
    Function<Long, Long> square = x -> x * x;
    Function<Long, Long> addOne = x -> x + 1;
    Function<Long, Long> squareAddOne = square.andThen(addOne);
    Function<Long, Long> addOneSquare = square.compose(addOne);
    Function<Long, Long> chainedFunction = ((Function<Long, Long>)(x -> x * x))
            .andThen(x -> x + 1)
            .andThen(x -> x * x);
 @Test
 public void shouldFunctionWork() {
     Assertions.assertThat(squareAddOne.apply(2l)).isEqualTo(5);
     Assertions.assertThat(addOneSquare.apply(2l)).isEqualTo(9);
     Assertions.assertThat(chainedFunction.apply(2l)).isEqualTo(25);
 }
static class Math{

        public static final BiFunction<Integer, Integer, Integer> ADDITION = (a, b) -> a + b;

        public static final BiFunction<Integer, Integer, Integer> SUBTRACTION = (a, b) -> a - b;

        public static  final BiFunction<Integer, Integer, Integer> MULTIPLICATION = (a, b) -> a * b;

        public static final BiFunction<Integer, Integer, Integer> DIVISION = (a, b) -> a / b;
}
@Test
public void shouldBiFunctionWork() {
    log.info("{}",Math.ADDITION.apply(3, 4));
    log.info("{}",Math.DIVISION.apply(3, 0));
}

}
