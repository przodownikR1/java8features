package pl.java.scalatech.stream;

import java.util.stream.IntStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuildStreamTest {

    @Test
    public void shouldBuildStream() {
        IntStream ones = IntStream.generate(() -> 1);
        ones.limit(10).forEach(l -> log.info("{}", l));
    }

}
