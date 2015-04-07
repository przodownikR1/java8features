package pl.java.scalatech.functional;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
@Slf4j
public class FunctionalTest {

    @Test
    public void shouldPrint(){
        Action a = ()-> log.info("{}","sample test"); 
        a.print();
        a.defaultMethod();
    }
}
