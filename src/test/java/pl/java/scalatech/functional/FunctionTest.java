package pl.java.scalatech.functional;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;

import pl.java.scalatech.functional.bean.Country;

import com.google.common.collect.Lists;

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
        final Function<Integer, String> fun = t -> "result is " + t;
        assertThat(fun.apply(1)).isEqualTo("result is 10");
    }

    @Test
    public void shouldSimpleSupplierWork2() {
        final Supplier<Integer> answer = () -> 10;
        assertThat(answer.get()).isEqualTo(10);
    }

}

interface CountryFactory<C extends Country> {
    C create(Long id, String name);
}
