package pl.java.scalatech.functional;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.functional.bean.Country;

@Slf4j
public class FunctionTest {
    @Test
    public void functionTest() {
        Function<String, String> s = x -> x + " " + x;
        Function<Integer, Integer> foo = x -> x + 1;

        Assertions.assertThat(foo.apply(10)).isEqualTo(11);
        Assertions.assertThat(s.apply("home")).isEqualTo("home home");

    }

    public void unaryOperatorTest() {

        // This returns one value of the same type as its one parameter.
        UnaryOperator<Integer> operator = v -> v * 2;
        // the same as below
        Function<Integer, Integer> function = v -> v * 2;
        Assertions.assertThat(function.apply(2)).isEqualTo(operator.apply(2));

        List<Integer> list = Lists.newArrayList(1, 2, 3);
        list.replaceAll(element -> element + 2);
        Assertions.assertThat(list).isEqualTo(Lists.newArrayList(3, 4, 5));

    }

    @Test
    public void functionTest2() {
        Function<Integer, Integer> one = x -> x + 1;
        Function<Integer, Integer> two = x -> 2 * x;
        Integer oneResult = one.andThen(two).apply(2);
        Assertions.assertThat(oneResult).isEqualTo(6);
        Integer twoResult = one.compose(two).apply(2);
        Assertions.assertThat(twoResult).isEqualTo(5);
    }

    @Test
    public void shouldSimpleSupplierWork() {
        display(() -> 1);
    }

    @Test
    public void shouldSupplierCreateCountry() {
        Supplier<Country> countrySupplier = Country::new;
        Country user = countrySupplier.get();

        Consumer<Country> countryConsumer = (c) -> log.info("Country:  {} ", c.getName());
        countryConsumer.accept(user);

    }

    @Test
    public void shouldSupplierFactoryWork() {
        CountryFactory<Country> factory = Country::new;
        Assertions.assertThat(factory.create(1l, "POLAND").getId()).isEqualTo(1l);
    }

    static void display(Supplier<Integer> arg) {
        log.info("+++  {}", arg.get());
    }

    @Test
    public void shouldSimpleFunctionWork() {
        final Function<Integer, String> fun = t -> "result is  " + t;
        String result = CharMatcher.WHITESPACE.trimAndCollapseFrom(fun.apply(1), ' ');
        assertThat(result).isEqualTo("result is 1");
    }

    @Test
    public void shouldSimpleSupplierWork2() {
        final Supplier<Integer> answer = () -> 10;
        assertThat(answer.get()).isEqualTo(10);
    }
   @Test
    public void simpleBiFunctionTest() {
       BiFunction<Integer, Integer,Integer > addInteger = (a,b)  -> a +b ;
       assertThat(addInteger.apply(3, 7)).isEqualTo(10);
       UnaryOperator<Integer> next = x -> x+2;
       assertThat(next.apply(3)).isEqualTo(5);
       assertThat(addInteger.andThen(next).apply(3, 2)).isEqualTo(7);

       BiFunction<String, String, String> concat = (a,b) -> a + b;
       log.info("{}",concat.apply("Hello ", "slawek"));


    }
   @Test
   public void testFunctionConcatMethod() {
          stringCounter(x->  x +" : " + x.length(),Lists.newArrayList("Slawek","kalina","jola"));
   }

   public static void stringCounter(Function<String, String> greeter,List<String> list) {
       for(String name : list) {
       log.info("{}",greeter.apply(name));
       }
       }

    @Test
    public void simpleFunctionTest() {
        Function<String, String > add = x ->  "Hello " +x ;
        assertThat(add.apply("slawek")).isEqualTo("Hello slawek");



    }

}

interface CountryFactory<C extends Country> {
    C create(Long id, String name);
}
