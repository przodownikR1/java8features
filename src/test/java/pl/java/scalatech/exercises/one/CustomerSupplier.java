package pl.java.scalatech.exercises.one;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

import java.math.BigDecimal;
import java.util.function.Supplier;

import pl.java.scalatech.guava.Customer;

public class CustomerSupplier implements Supplier<Customer> {

    public static final CustomerSupplier INSTANCE = new CustomerSupplier();

    private CustomerSupplier() {

    }

    @Override
    public Customer get() {
        return Customer.builder().firstName(randomAlphabetic(10)).lastName(randomAlphabetic(15)).salary(new BigDecimal(randomNumeric(5))).build();
    }

}
