package pl.java.scalatech.lambda;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import pl.java.scalatech.functional.Action;

@Slf4j
public class ActionTest {
    @Test
    public void shouldLambaWork() {
        Action a = () -> {
            log.info("+++  invoke print method ...");
        };
        a.print();
    }

}
