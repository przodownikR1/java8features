package pl.java.scalatech.assertj_simple;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

import java.math.BigDecimal;

import org.junit.Test;

import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.pojo.Person;

public class FirstAssertjTest extends DataPrepareTest {
    @Test
    public void firstTest() {
        assertThat(persons).hasSize(4).contains(new Person("slawek", "przodownik", new BigDecimal(12)));
    }

    @Test
    public void shouldCatchRe() {
        assertThatThrownBy(new MyService()::someMethod).isInstanceOf(RuntimeException.class).hasMessage("re").hasNoCause();
    }

    @Test
    public void shouldCatchReByIae() {
        assertThatThrownBy(() -> new MyService().someMethod2(true)).isInstanceOf(RuntimeException.class).hasMessage("re-> iae")
                .hasCauseInstanceOf(IllegalArgumentException.class);
    }

}

class MyService {
    public void someMethod() {
        throw new RuntimeException("re");
    }

    public void someMethod2(boolean b) {
        throw new RuntimeException("re-> iae", new IllegalArgumentException("args error"));
    }
}