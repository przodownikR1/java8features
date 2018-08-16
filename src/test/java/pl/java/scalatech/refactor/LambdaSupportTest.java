package pl.java.scalatech.refactor;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class LambdaSupportTest {
    @Test
    public void test() {
        System.err.println("todo");
        List<String> abs = Lists.newArrayList("a", "b", "c", "d");
        abs.stream().forEach(t -> System.err.println(t));
    }

}
