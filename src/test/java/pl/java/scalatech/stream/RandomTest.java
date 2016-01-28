package pl.java.scalatech.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RandomTest {

    @Test
    public void shouldRandomGenerateTest(){
      log.info("{}",Stream.generate(Math::random).limit(100).collect(Collectors.toList()));
    }

}
