package pl.java.scalatech.language_feature.nullhandler;

import java.util.Optional;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionalNullProtectedTest {
    Outer outer = new Outer();

    @Test
    public void oldFashionedApproachTest() {

        if (outer != null && outer.nested != null && outer.nested.inner != null && outer.nested.inner.foo != null) {
            log.info("Foo is {}", outer.nested.inner.foo);
        }

    }

    @Test
    public void newNullProtectedTest() {
        Optional<String> result = Optional.ofNullable(outer)
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo));

        if (result.isPresent()) {
            log.info("Foo is {}", result.get());
        }
    }

    private static class Outer {

        Nested nested = new Nested();
    }

    private static class Nested {

        Inner inner = new Inner();
    }

    private static class Inner {

        String foo;
    }
}
