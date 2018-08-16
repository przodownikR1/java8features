package pl.java.scalatech.guava;

import java.lang.reflect.Type;

import org.junit.Test;

import com.google.common.reflect.TypeToken;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TypeTokenTest {
    @Test
    public void shouldGenericTypeWork() {
        GuavaPerson<String> type = new GuavaSlawek();
        log.info("{}", type.getType());

    }

}

abstract class Person<T> {
    private final Class<T> type;

    protected Person(Class<T> type) {
        this.type = type;
    }
}

class Slawek extends Person<String> {
    public Slawek() {
        super(String.class);
    }
}

abstract class GuavaPerson<T> {
    private final TypeToken<T> typeToken = new TypeToken<T>(getClass()) {
    };
    @Getter
    private final Type type = typeToken.getType();

}

class GuavaSlawek extends GuavaPerson<String> {

}
