package pl.java.scalatech.lambda;

import static org.fest.assertions.Assertions.assertThat;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import pl.java.scalatech.functional.Action;

@Slf4j
public class ActionTest {
    @Test
    public void shouldLambaWork() {
        Action a = () -> {
            log.info("+++  invoke print method ...");
        };
        a.print();
    }

    @Test
    public void test2() {
        UnaryOperator<Integer> operator = v -> v * 2;
        Function<Integer, Integer> function = v -> v * 2;
        assertThat(operator.apply(2)).isEqualTo(function.apply(2));
        Runnable r = () -> log.info("run .....");
        Thread t = new Thread(r);
        t.start();
    }
}
