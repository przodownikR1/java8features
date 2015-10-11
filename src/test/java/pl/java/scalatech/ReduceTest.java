package pl.java.scalatech;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class ReduceTest {
    @Test
    public void reduceTest() {
          List<Integer> integers = Lists.newArrayList(1,2,3,4,5);

          Integer sum = integers.stream().reduce(0, (x,y) -> x + y);
          Assertions.assertThat(sum).isEqualTo(15);
    }

}
