package pl.java.scalatech.stream;

import java.util.stream.IntStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class RangeTest {

    @Test
    public void shouldRangeStream() {
        IntStream.range(1, 10).forEach(l->log.info("{}",l));

        IntStream.range(0, 10).forEach(l->

        log.info("{} : {}",l,isPrime(l)));

    }

    private boolean isPrime(int n) {
        boolean flag = IntStream.range(2, n).noneMatch(l->n%2==0);
        return n>1 && flag;
    }



}
