package pl.java.scalatech.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.DataPrepareTest;

@Slf4j
public class OrDefaultTest extends DataPrepareTest {
    @Test
    public void shouldMapCountOldApproach() {
        Map<String, Long> map = new HashMap<>();
        for (String s : names) {
            Long count = map.get(s);
            map.put(s, count == null ? 1L : count + 1);
        }
        log.info("{}", map);
    }

    @Test
    public void shouldDefaultOrNull() {
        Map<String, Long> map = new HashMap<>();
        for (String s : names) {
            map.put(s, 1 + map.getOrDefault(s, 0L));
        }
        log.info("{}", map);
    }

    @Test
    public void shouldGuavaMultiMapWork() {
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(names);
        log.info("{}", wordsMultiset);
    }
}
