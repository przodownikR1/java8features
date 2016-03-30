package pl.java.scalatech.referenceType;

import java.math.BigDecimal;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.refMet.UserSpec;

@Slf4j
public class TestConstructorRef {
    @Test
    public void shouldChoiceRightConstructor() {
        UserCreator<UserSpec> uc = UserSpec::new;
        log.info("{}", uc.create("slawek", BigDecimal.valueOf(112)));
    }
}
