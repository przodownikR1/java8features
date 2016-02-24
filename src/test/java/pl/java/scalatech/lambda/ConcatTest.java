package pl.java.scalatech.lambda;

import static java.lang.System.getProperties;

import java.math.BigDecimal;
import java.util.IllegalFormatException;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcatTest {

    Concat<String> concat = (s, v) -> s + " : " + v;
    Concat<Double> concatD = (s, v) -> s + v;
    Concat<BigDecimal> concatB = (s, v) -> s.add(v);

    @Test
    public void concatTest() {
        Assertions.assertThat(concat.concat("slawek", "borowiec")).isEqualTo("slawek : borowiec");
        Assertions.assertThat(concatD.concat(12.3d, 3.2d)).isEqualTo(15.5);
        Assertions.assertThat(concatB.concat(BigDecimal.valueOf(3), BigDecimal.valueOf(4))).isEqualTo(BigDecimal.valueOf(7));
    }

    ConcatEx ex = (s, v) -> {
        if (s == 0) { throw new IllegalArgumentException(); }
        return s + ":" + v;
    };

    @Test(expected = IllegalArgumentException.class)
    public void concatExTest() {
        ex.concat(0, 2);
    }

    BinaryOperator<String> stringConcat = (s, v) -> s + " : " + v;

    @Test
    public void shouldBinaryOperatorEqualsAsConcatFunctionalInterface() {
        Assertions.assertThat(stringConcat.apply("slawek", "borowiec")).isEqualTo("slawek : borowiec");
    }

    @Test
    public void fileSeparator() {
        log.info("{}", System.getenv());
        log.info("{}", searchSystemProperty(e -> e.getKey().equals("file.separator")));
        log.info("{}",System.getProperty("file.separator"));

    }  
    @Deprecated 
    public static String searchSystemProperty(Predicate<Entry<?, ?>> predicate) {
        return (String) getProperties().entrySet().stream().filter(predicate).map(entry -> entry.getValue()).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not exists system variable .."));
    }
}

// R apply(T t1, T t2)
// operator-type
@FunctionalInterface
interface ConcatEx {
public String concat(Integer n1, Integer n2) throws IllegalFormatException;
}

@FunctionalInterface
interface Concat<T> {
    T concat(T t ,T v);
}