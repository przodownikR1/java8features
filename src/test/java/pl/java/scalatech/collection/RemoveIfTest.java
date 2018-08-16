package pl.java.scalatech.collection;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.stream.Collectors.toList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.DataPrepareTest;

@Slf4j
public class RemoveIfTest extends DataPrepareTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Map<String, String> capitols = newHashMap();

    @Override
    @Before
    public void init() {
        capitols.put("Poland", "Warsaw");
        capitols.put("Rusia", "Moscow");
        capitols.put("UK", "London");
        capitols.put("Germany", "Berlin");
        capitols.put("Spain", null);
    }

    @Test
    public void shouldRemoveProperEntry() {
        Collection<String> list = newArrayList("kalina", "karol", "slawek", "pawel", "agnieszka");
        list.removeIf(element -> element.startsWith("p"));
        assertThat(list).containsOnly("kalina", "karol", "slawek", "agnieszka");
    }

    @Test
    public void shouldGetOrDefaultWork() {
        String capitalPortugal = capitols.getOrDefault("Portugal", "Lisbona");
        assertThat(capitalPortugal).isEqualTo("Lisbona");
        assertThat(capitols.get("Poland")).isEqualTo("Warsaw");

    }

    /*
     * V v = map.get(key);
     * if (v == null)
     * v = map.put(key, value);
     * return v;
     */

    @Test
    public void shouldPutIfAbsenceWork() {
        String capitolUSA = capitols.putIfAbsent("USA", "Washington");
        log.info("str {}", capitolUSA);
        log.info("map -> usa - > capitol {}", capitols.get("USA"));
        assertThat(capitols.get("USA")).isEqualTo("Washington");
        String capitolOfPoland = capitols.putIfAbsent("Poland", "Krakow");
        assertThat(capitolOfPoland).isEqualTo("Warsaw");

    }

    /*
     * if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
     * map.remove(key);
     * return true;
     * } else
     * return false;
     */
    @Test
    public void shouldRemoveWork() {
        capitols.put("TEST", "test");
        boolean ret = capitols.remove("TEST", "Warsow");
        assertThat(ret).isFalse();
        ret = capitols.remove("TEST", "test");
        assertThat(ret).isTrue();
    }

    /*
     * Map.replace(K, V)
     * if (map.containsKey(key)) {
     * return map.put(key, value);
     * } else
     * return null;
     * Map.replace(K, V, V)
     * if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
     * map.put(key, newValue);
     * return true;
     * } else
     * return false;
     */

    @Test
    public void shouldRemoveOddButConcurrentModificationExceptionThrow() {
        thrown.expect(ConcurrentModificationException.class);
        for (Integer i : values) {
            if (i % 2 == 0) {
                values.remove(i);
            }
        }
        log.info("{}", values);
    }

    @Test
    public void shouldRemoveOddUseIterator() {
        // given
        Assertions.assertThat(values).contains(1, 2, 3, 4, 6, 7, 8);
        // when
        for (Iterator<Integer> i = values.iterator(); i.hasNext();) {
            if (i.next() % 2 == 0) {
                i.remove();
            }
        }
        // then
        Assertions.assertThat(values).contains(1, 3, 5, 7);
    }

    @Test
    public void shouldRemoveOddUseJava8Features() {
        values.removeIf(i -> i % 2 == 0);
        Assertions.assertThat(values).contains(1, 3, 5, 7);
    }

    @Test(expected = UnsupportedOperationException.class)

    public void aTest() {
        List<String> vs = Arrays.asList("slawek", "borowiec", "polska", "przodownik");

        vs.removeIf(s -> s.length() > 6);
        log.info("vs : {}", vs);
    }

    @Test
    public void testNoParallel() {
        Collection<String> list = newArrayList("kalina", "karol", "slawek", "pawel", "agnieszka", "przodownik");
        List<String> result = list.stream().peek(t -> {
            log.info("++++ no parallel t");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

        }).filter(s -> s.length() > 6).map(s -> s.toUpperCase()).collect(toList());
        log.info("result : {}", result);
    }

    @Test
    public void testParallel() {
        Collection<String> list = newArrayList("kalina", "karol", "slawek", "pawel", "agnieszka", "przodownik");
        List<String> result = list.stream().parallel().peek(t -> {
            log.info("++++ parallel t");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

        }).filter(s -> s.length() > 6).map(s -> s.toUpperCase()).collect(toList());
        log.info("result : {}", result);
    }

}
