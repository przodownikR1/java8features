package pl.java.scalatech.assertj_simple;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.pojo.Person;

public class FirstAssertjTest extends DataPrepareTest {
    @Test
    public void firstTest() {
        assertThat(persons).hasSize(4).contains(new Person("slawek", "przodownik", new BigDecimal(12)));
    }

}
