package pl.java.scalatech.functional;

import java.util.function.Function;

import org.fest.assertions.Assertions;
import org.junit.Test;


public class FunctionTest {
    @Test
    public void functionTest() {
        Function<String, String> s = x->x+x;
        Function<Integer, Integer> foo = x->x+1;
        
    }
    @Test
    public void functionTest2() {
        Function<Integer, Integer> one = x->x+1;
        Function<Integer, Integer> two = x->2*x;
        Integer oneResult = one.andThen(two).apply(2);
        Assertions.assertThat(oneResult).isEqualTo(6);
        Integer twoResult = one.compose(two).apply(2);
        Assertions.assertThat(twoResult).isEqualTo(5);
    }
}
