package pl.java.scalatech.functional;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class BiFunctionFunctionTest {
        @Test
        public void test() {
        BiFunction<String, String, String> concat = (a, b) -> a + b;
        Function<String, Function<String, String>> curriedConcat = curry(concat);


        for (String greetings : newArrayList("Hello", "Guten Tag", "Bonjour")) {
        greetFolks(curriedConcat.apply(greetings + ", "  ));
        }
        }

        public static <T,U,V> Function<T,Function<U,V>> curry(BiFunction<T,U,V> bif) {
        return t -> (u -> bif.apply(t,u));
        }

        public static void greetFolks(Function<String, String> greeter) {
        for (String name : newArrayList("Alice", "Bob", "Cathy")) {
         log.info("{}",greeter.apply(name));
        }
        }
        @Test
        public void shouldBiFunctionWork(){
            BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result:" +(num1 + num2);
            Assertions.assertThat(biFunction.apply(1, 2)).isEqualTo("Result:3");
        }
}
