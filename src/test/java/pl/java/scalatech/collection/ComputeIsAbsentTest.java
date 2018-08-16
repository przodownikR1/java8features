package pl.java.scalatech.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComputeIsAbsentTest {

    HashMap<Integer, List<String>> db = new HashMap<>();

    public void add(String name, Integer grade) {
        db.computeIfAbsent(grade, key -> new ArrayList<>()).add(name);
    }

    public HashMap<Integer, List<String>> db() {
        return db;
    }

    public List<String> grade(Integer grade) {
        return db.computeIfAbsent(grade, key -> new ArrayList<>());
    }

    public HashMap<Integer, List<String>> sort() {
        db.keySet().stream().forEach(key -> Collections.sort(db.get(key)));
        return db;
    }

    @Test
    public void putInAbsentTest() {
        // adds an element with the specified Value
        Map<String, String> intMap = new HashMap<>();
        intMap.put("1", "Value1");
        intMap.put("2", "Value2");
        intMap.putIfAbsent("3", "Value3");
        intMap.putIfAbsent("3", "!!Value3");
        intMap.keySet().stream().forEach(s -> log.info("{} {}", s, intMap.get(s)));

    }

    @Test
    public void computeInAbsentTest() {
        // adds an element with the value computed using the Key.
        Map<Integer, String> intMap = new HashMap<>();
        intMap.put(1, "Value1");
        intMap.put(2, "Value2");
        intMap.computeIfAbsent(3, e -> "" + "Value".length());
        intMap.computeIfAbsent(3, e -> "" + "Value1".length());// ommit
        intMap.computeIfAbsent(5, e -> "" + "Value1".length());
        intMap.keySet().stream().forEach(s -> log.info("compute {} {}", s, intMap.get(s)));
    }

    @Test
    public void test() {
        add("slawek", 3);
        add("slawek", 5);
        add("slawek", 5);
        grade(3);
        grade(3);
        grade(2);
        db.keySet().stream().forEach(i -> log.info("{} ,{}", i, db.get(i)));

    }

    @Test
    public void functionTest() {
        Map<Integer, String> map = Maps.newHashMap();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        log.info("key 3 value:'{}'", map.get(3));

        log.info("map computeIfPresent:'{}'", map.computeIfPresent(9, (num, val) -> {
            System.err.println("num : " + num);
            System.err.println("val : " + val);
            return "new value";
        }));

        log.info("key 9 containsKey:'{}'", map.containsKey(9));

        log.info("computeIfAbsent 23 :'{}'", map.computeIfAbsent(23, num -> "val" + num));

        log.info("map.containsKey(23):'{}'", map.containsKey(23));

        log.info("computeIfAbsent 3:'{}'", map.computeIfAbsent(3, num -> "bam"));
        log.info("get 3:'{}'", map.get(3));

        map.remove(3, "val");

        log.info("remove get 3:'{}'", map.get(3));

        map.remove(3, "val3");

        log.info("remove get 3:'{}'", map.get(3));

        log.info("getDefault:'{}'", map.getOrDefault(43, "not found"));

        log.info("merge:'{}'", map.merge(9, "val9", (value, newValue) -> value.concat(newValue)));

        log.info("merge:'{}'", map.merge(9, "count", (value, newValue) -> value.concat(newValue)));
    }
}