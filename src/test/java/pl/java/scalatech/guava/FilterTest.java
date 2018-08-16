package pl.java.scalatech.guava;

import java.math.BigDecimal;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.guava.Customer.Status;

@Slf4j
public class FilterTest {

    List<Customer> customers = Lists.newArrayList();
    final Predicate<Customer> HIGH_SALARY = input -> {
        if (input.getSalary().intValue() > 121) {
            return true;
        }
        return false;

    };

    final Function<Customer, Worker> WORKER_PRODUCERS = input -> new Worker(input.getFirstName() + " " + input.getLastName());

    @Before
    public void init() {
        customers.add(new Customer(new BigDecimal("120"), "slawek", "borowiec", Status.BUSY));
        customers.add(new Customer(new BigDecimal("20"), "agnieszka", "borowiec", Status.LAZY));
        customers.add(new Customer(new BigDecimal("520"), "kalina", "borowiec", Status.BUSY));
        customers.add(new Customer(new BigDecimal("160"), "marek", "kalinowski", Status.BUSY));
        customers.add(new Customer(new BigDecimal("60"), "slawek", "rudkowski", Status.BUSY));

    }

    @Test
    public void shouldFilterTest() {
        Iterable<Customer> busyCustomers = Iterables.filter(customers, customer -> Customer.Status.BUSY.equals(customer.getStatus()));
        log.info(Joiner.on("\n").join(busyCustomers));
    }

    @Test
    public void shouldFluentInterationWork() {

        List<Worker> workers = FluentIterable.from(customers).filter(HIGH_SALARY).transform(WORKER_PRODUCERS).toList();
        List<Worker> expected = Lists.newArrayList(new Worker("kalina borowiec"), new Worker("marek kalinowski"));
        Assertions.assertThat(workers).hasSize(2).isEqualTo(expected);
    }

}
