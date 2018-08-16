package pl.java.scalatech.exception;

import org.assertj.core.api.StrictAssertions;
import org.junit.Test;

public class JAssertExceptionTest {

    @Test
    public void shouldJAssertHandleException() {
        StrictAssertions.assertThatThrownBy(new SimpleExceptionGenerator()::throwRuntimeException).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("illegal test").hasNoCause();
    }

    @Test
    public void shouldJAssertHandleLamdbaException() {
        StrictAssertions.assertThatThrownBy(() -> new SimpleExceptionGenerator().throwsRuntimeWithCause()).isInstanceOf(MyRuntimeException.class)
                .hasMessage("java.lang.IllegalStateException: Illegal state").hasCauseInstanceOf(IllegalStateException.class);
    }

    @Test
    public void bddStyle() {
        // given

        // when
        Throwable throwable = StrictAssertions.catchThrowable(new SimpleExceptionGenerator()::throwRuntimeException);

        // then
        StrictAssertions.assertThat(throwable).isNotNull().hasMessage("illegal test");
    }
}
