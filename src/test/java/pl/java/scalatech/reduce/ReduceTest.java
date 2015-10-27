package pl.java.scalatech.reduce;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ReduceTest {
  @Test  
public void shouldReduceWork(){
      Stream<Integer> intList = Arrays.asList(2, 3, 4).stream();
      Optional<Integer> product = intList.reduce((x, y) -> x * y);

      // Optional
      log.info("2*3*4=" + product.orElse(0));
}
}
