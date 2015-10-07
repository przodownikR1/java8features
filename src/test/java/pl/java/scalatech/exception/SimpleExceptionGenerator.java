package pl.java.scalatech.exception;

import java.io.IOException;

public class SimpleExceptionGenerator {

    public void throwRuntimeException() {
        throw new IllegalArgumentException("illegal test");
    }

    public void throwException() throws IOException {
        throw new IOException("io exception test");
    }

    public void throwsRuntimeWithCause() {
        throw new MyRuntimeException(new IllegalStateException("Illegal state"));
    }

}
