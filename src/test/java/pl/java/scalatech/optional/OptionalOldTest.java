package pl.java.scalatech.optional;

import java.util.Map;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;
@Slf4j
public class OptionalOldTest {

    
    private Map<String,Customer> customers = Maps.newHashMap();
    private Customer customer;
    @Before
    public void init() {
        customer = Customer.builder().name("przodownik").address(new Address("warsaw")).build();
        customers.put("borowiec", customer);
    }
    @Test
    public void  shouldNullProblemEliminate() {
        if(customers.get("borowiec")!= null) {
            Customer customer = customers.get("borowiec");
            if(customer!= null) {
                Address address = customer.getAddress();
                if(address != null) {
                      log.info("city : {}"  ,address.getCity());
                }
            }
        }
    }
    @Test
    public void shouldNullProctectionJava8() {
        String result = Optional.ofNullable(customers.get("borowiec")).map(Customer::getAddress).map(Address::getCity).filter(name->!name.isEmpty()).orElse("Radom");
        log.info("java 8 : optional : {}",result);
        
    }
}
