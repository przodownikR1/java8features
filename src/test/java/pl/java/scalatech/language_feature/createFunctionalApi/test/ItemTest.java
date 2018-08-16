package pl.java.scalatech.language_feature.createFunctionalApi.test;

import static java.util.stream.Stream.of;
import static pl.java.scalatech.api.Item.builder;

import java.math.BigDecimal;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.api.Item;

@Slf4j
public class ItemTest {

    @Test
    public void test() {
        Item item = builder().name("tv").quantity(2).price(BigDecimal.valueOf(2000)).build();
        log.info("{}", of(item).map(Item::getName).findFirst().get());
    }

}
