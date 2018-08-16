package pl.java.scalatech.functional;

import org.assertj.core.api.StrictAssertions;
import org.junit.Test;

public class FunctionalInterfaceTest {

    @Test
    public void shouldFunctionalInterfaceWork() {
        StringToIntMapper m = s -> s.length();
        StrictAssertions.assertThat(m.map("slawek")).isEqualTo(6);
    }
}
