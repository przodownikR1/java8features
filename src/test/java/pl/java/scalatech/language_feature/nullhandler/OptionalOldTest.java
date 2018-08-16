package pl.java.scalatech.language_feature.nullhandler;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

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
        assertThat("notFound").isEqualTo(customerName.orElse("notFound"));
        assertThat(customerName.orElseGet(generateRandomString())).isNotEmpty();
        // log.info("orElseGet {}", );
        // orElseThrow(RuntimeException::new);
    }

    @Test
    public void shouldOptionalAsNullWork() {
        Optional<String> name = Optional.ofNullable(null);
        assertThat(name.isPresent()).isFalse();

        assertThat(name.orElseGet(() -> "borowiec")).isEqualTo("borowiec");

        assertThat(name.map(s -> "Hello " + s + "!").orElse("kowalski")).isEqualTo("kowalski");
    }

    @Test
    public void shouldOptionalAsExistsNameWork() {
        Optional<String> name = Optional.ofNullable("borowiec");
        assertThat(name.isPresent()).isTrue();

        assertThat(name.orElseGet(() -> "kowalski")).isEqualTo("borowiec");

        assertThat(name.map(s -> "Hello " + s + "!").orElse("kowalskie")).isEqualTo("Hello borowiec!");
    }

    Optional<String> simulateCustomer(String userId) {
        return Optional.empty();
    }

    private Supplier<? extends String> generateRandomString() {
        return () -> UUID.randomUUID().toString();
    }

}
