package pl.java.scalatech.join;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.timeTest.TimedTest;

@Slf4j
public class JoinTest {
    private final static String[] strs = { "yamaha", "kawa", "honda", "suka" };
    @Rule
    public TimedTest timeTest = new TimedTest();

    @Test
    public void shouldJoinString() {
        final String joined = String.join(" ", strs);
        assertThat(joined).isEqualTo("yamaha kawa honda suka");
    }

    @Test
    public void shouldCreateIp() {
        StringJoiner joiner = new StringJoiner(".", "(", ")");
        joiner.add("192");
        joiner.add("168");
        joiner.add("1");
        joiner.add("19");
        String ipAddress = joiner.toString();
        assertThat(ipAddress).isEqualTo("(192.168.1.19)");
    }

    @Test
    public void shouldJoinByStream() {
        List<String> strs = Lists.newArrayList("192", "168", "1", "19");
        String ipAddress = strs.stream().collect(Collectors.joining(".", "(", ")"));
        assertThat(ipAddress).isEqualTo("(192.168.1.19)");
    }

    @Test
    public void shouldOmmitNull() {
         List<String> names =Lists.newArrayList("slawek","tata",null,"bak");
         String joined = names.stream().filter(l->l!=null).collect(Collectors.joining(", "));
         Assertions.assertThat(joined).isEqualTo("slawek, tata, bak");
    }

    @Test
    public void shouldOmmitSecondNull() {
         List<String> names =Lists.newArrayList("slawek","tata",null,"bak");
         String joined = names.stream().filter(Objects::nonNull).collect(Collectors.joining(", "));
         Assertions.assertThat(joined).isEqualTo("slawek, tata, bak");
    }

}
