package pl.java.scalatech;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.Collection;

import org.assertj.core.api.StrictAssertions;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lombok.extern.slf4j.Slf4j;

@RunWith(value = Parameterized.class)
@Slf4j
public class JunitParameterized {

    private String value;

    @Parameters
    public static Collection<Object[]> data() {
        return newArrayList(new Object[] { "World" }, new Object[] { "java" });

    }

    public JunitParameterized(String value) {
        this.value = value;
    }

    @Test
    public void RegExCheck() {
        log.info("{}", value);
        StrictAssertions.assertThat(value.matches("\\w+"));
    }

    @Test
    public void shouldConvertListOfStringToArrayOfString() {
        String[] strings = Lists.newArrayList("slawek", "borowiec").parallelStream().toArray(String[]::new);
        StrictAssertions.assertThat(strings).contains("slawek", "borowiec");
    }

}
