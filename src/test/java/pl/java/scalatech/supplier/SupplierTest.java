package pl.java.scalatech.supplier;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SupplierTest {
    @Test
    public void supplierExample() {
        BooleanSupplier bs = () -> true;
        IntSupplier is = () -> 2;
        LongSupplier ls = System::currentTimeMillis;
        DoubleSupplier ds = Math::random;
        Supplier<Map<String, String>> ms = TreeMap::new;
        log.info("ds {}",ds.getAsDouble());
    }
}
