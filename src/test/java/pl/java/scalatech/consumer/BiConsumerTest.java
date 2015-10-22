package pl.java.scalatech.consumer;

import java.util.Map;
import java.util.function.BiConsumer;

import org.junit.Test;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BiConsumerTest {

    @Test
    public void shouldCheckThisAndThat() {
        Map<Integer, String> map = Maps.newHashMap();
        map.put(1, "yama");
        map.put(2, "suka");
        map.put(3, "kawa");
        // Given

        // When
        BiConsumer<Integer, String> biConsumer = (key, value) -> log.info("Key: {} => value: {}", key, value);
        // Then
        map.forEach(biConsumer);
    }

}
