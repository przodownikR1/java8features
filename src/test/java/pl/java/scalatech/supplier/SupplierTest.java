package pl.java.scalatech.supplier;

import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SupplierTest {
    @Test
    public void supplierExample() {
        DoubleSupplier ds = Math::random;
        log.info("ds {}", ds.getAsDouble());
    }

    Supplier<Integer> randomIntegers = () -> {
        Random random = new Random();
        int number = random.nextInt(10);
        while (number >= 3 && number <= 8) {
            number = random.nextInt(10);
        }
        return number;
    };

    @Test
    public void shouldGenerateNumberFrom0to9exclude3To8() {
        for (int i = 0; i < 10; i++) {
            log.info("{}", randomIntegers.get());
        }
    }
}
