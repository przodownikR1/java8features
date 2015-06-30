package pl.java.scalatech.functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
@Slf4j
public class ConsumerTest {

    @Test
    public void shouldConsumerWork() {
        
        Supplier<String> strSupplier = () -> "Hello World";
        String ret = strSupplier.get();
        log.info("+++  {}",ret);
        Consumer<String> strConsumer = (c) -> log.info("Str:  {} ", c);
        
        String s = "Hello World";
        Consumer<String> c1 = (t) -> log.info("+++ c1 : {}",t) ;
        Consumer<String> c2 = (c) -> log.info(" c2 :  {}",c);
        Consumer<String> c3 = c1.andThen(c2);
        c3.accept(ret);
    }
}
