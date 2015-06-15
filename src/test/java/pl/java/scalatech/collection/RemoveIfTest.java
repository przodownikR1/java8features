package pl.java.scalatech.collection;

import java.util.Collection;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.collect.Lists;

public class RemoveIfTest {

    @Test
    public void shouldRemoveProperEntry() {
        Collection<String> list = Lists.newArrayList("kalina", "karol", "slawek", "pawel", "agnieszka");
        list.removeIf(element -> element.startsWith("p"));
        Assertions.assertThat(list).containsOnly("kalina", "karol", "slawek", "agnieszka");

    }
}
