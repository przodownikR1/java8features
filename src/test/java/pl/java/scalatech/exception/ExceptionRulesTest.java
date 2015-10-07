package pl.java.scalatech.exception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionRulesTest {

    private SimpleExceptionGenerator seg = new SimpleExceptionGenerator();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldHandleException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("illegal test");
        seg.throwRuntimeException();
    }
}
