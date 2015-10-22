package pl.java.scalatech.functional;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FunctionalInterfaceTest {

     @Test
     public void shouldFunctionalInterfaceWork() {
         StringToIntMapper m = s -> s.length();
         Assertions.assertThat(m.map("slawek")).isEqualTo(6);
     }
}
