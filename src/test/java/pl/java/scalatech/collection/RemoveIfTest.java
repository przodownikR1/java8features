package pl.java.scalatech.collection;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Collection;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.junit.Before;
import org.junit.Test;

@Slf4j
public class RemoveIfTest {

    private Map<String, String> capitols = newHashMap();

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
}
