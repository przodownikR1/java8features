package pl.java.scalatech.exercises.one;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.guava.Customer;
@Slf4j
public class StreamSupplierTest {
   @Test
    public void shouldSupplierGenerate(){
       
       Stream<Customer> customerStream = Stream.generate(CustomerSupplier.INSTANCE);
       List<Customer> persons = customerStream.limit(30).collect(Collectors.toList());
       assertThat(persons).hasSize(30);
       
    }
   @Test
   public void shouldDecorateByStatus(){
       Stream<Customer> customerStream = Stream.generate(CustomerSupplier.INSTANCE);
       List<Customer> persons = customerStream.limit(30).collect(Collectors.toList());
       persons.stream().filter(c-> c.getSalary().intValue()%2==0).forEach(CustomerBusyConsumer.INSTANCE);
       log.info(" count : {}",persons.stream().filter(c-> c.getSalary().intValue()%2==0).peek(p->log.info("{}",p)).count());
       
   }
    
}
