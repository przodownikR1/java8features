package pl.java.scalatech.stream;

import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LazyTest {
    
    @Test
    public void shouldLazyWork(){ //10 oper
        log.info("shouldLazyWork");
    Stream.of("d", "a", "b", "b", "c")
    .filter(s -> {
        log.info("filter : {}",s);
        return true;
    })
    .forEach(s -> log.info("foreach : {}",s));
    }
    @Test
    public void shouldLazy2Work(){//11 oper
        log.info("shouldLazy2Work");
        Stream.of("d2", "a2", "b1", "b3","c")
        .map(s -> {
            log.info("map : {}",s);
            return s.toUpperCase();
        })
        .filter(s -> {
            log.info("filter : {}",s);
            return s.startsWith("A");
        })
        .forEach(s -> log.info("foreach : {}",s));
    }
    @Test
    public void lazyReduceOperation(){ //7 oper
        log.info("lazyReduceOperation");
    Stream.of("d2", "a2", "b1", "b3", "c")
    .filter(s -> {
        log.info("filter : {}",s);
        return s.startsWith("a");
    })
    .map(s -> {
        log.info("map : {}",s);
        return s.toUpperCase();
    })
    .forEach(s -> log.info("foreach : {}",s));
    }
}
