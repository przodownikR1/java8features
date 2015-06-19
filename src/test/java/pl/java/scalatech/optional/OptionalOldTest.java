package pl.java.scalatech.optional;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;

@Slf4j
public class OptionalOldTest {

    private Map<String, Customer> customers = Maps.newHashMap();
    private Customer customer;

    @Before
    public void init() {
        customer = Customer.builder().name("przodownik").address(new Address("warsaw")).build();
        customers.put("borowiec", customer);
    }

    @Test
    public void shouldNullProblemEliminate() {
        if (customers.get("borowiec") != null) {
            Customer customer = customers.get("borowiec");
            if (customer != null) {
                Address address = customer.getAddress();
                if (address != null) {
                    log.info("city : {}", address.getCity());
                }
            }
        }
    }

    @Test
    public void shouldNullProctectionJava8() {
        String result = Optional.ofNullable(customers.get("borowiec")).map(Customer::getAddress).map(Address::getCity).filter(name -> !name.isEmpty())
                .orElse("Radom");
        log.info("java 8 : optional : {}", result);

    }

    @Test
    public void shouldSimpleOptionalWork() {
        Optional<String> customerName = simulateCustomer("1");
        if (customerName.isPresent()) {
            log.info("is present!");
        }
        customerName.ifPresent(x -> log.info("isPresent  {}", x));
        Assertions.assertThat("notFound").isEqualTo(customerName.orElse("notFound"));
        Assertions.assertThat(customerName.orElseGet(generateRandomString())).isNotEmpty();
        // log.info("orElseGet {}", );
        // orElseThrow(RuntimeException::new);
    }

    Optional<String> simulateCustomer(String userId) {
        return Optional.empty();
    }

    private Supplier<? extends String> generateRandomString() {
        return () -> UUID.randomUUID().toString();
    }

}
