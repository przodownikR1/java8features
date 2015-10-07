package pl.java.scalatech.exception;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class JAssertExceptionTest {

    @Test
    public void shouldJAssertHandleException() {
        Assertions.assertThatThrownBy(new SimpleExceptionGenerator()::throwRuntimeException).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("illegal test").hasNoCause();
    }

    @Test
    public void shouldJAssertHandleLamdbaException() {
        Assertions.assertThatThrownBy(() -> new SimpleExceptionGenerator().throwsRuntimeWithCause()).isInstanceOf(MyRuntimeException.class)
                .hasMessage("java.lang.IllegalStateException: Illegal state").hasCauseInstanceOf(IllegalStateException.class);
    }

    @Test
    public void bddStyle() {
        //given

        //when
        Throwable throwable = Assertions.catchThrowable(new SimpleExceptionGenerator()::throwRuntimeException);

        //then
        Assertions.assertThat(throwable).isNotNull().hasMessage("illegal test");
    }
}
