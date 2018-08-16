package pl.java.scalatech.language_feature.closure;

import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClosureTest {

    @Test
    public void shouldClosureWork() {
        Closure ce = new Closure();
        final Function<String, String> function = ce.getStringOperation();
        log.info("{}", function.apply("Hello Worls"));

    }
}

class Closure {
    int instanceLength;

    public Function<String, String> getStringOperation() {
        String seperator = ":";

        return target -> {
            int localLength = target.length();
            instanceLength = target.length();
            return target.toLowerCase() + seperator + instanceLength + seperator + localLength;
        };
    }
}
