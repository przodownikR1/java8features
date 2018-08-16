package pl.java.scalatech.exercises.one;

import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.guava.Customer;
import pl.java.scalatech.guava.Customer.Status;

@Slf4j
public class CustomerBusyConsumer implements Consumer<Customer> {
    public static final CustomerBusyConsumer INSTANCE = new CustomerBusyConsumer();

    private CustomerBusyConsumer() {
    }

    @Override
    public void accept(Customer customer) {
        customer.setStatus(Status.BUSY);
        log.debug("++++   {}", customer);

    }

}
