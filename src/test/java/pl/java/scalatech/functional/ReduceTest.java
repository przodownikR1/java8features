package pl.java.scalatech.functional;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

import org.junit.Test;

import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.pojo.Person;

public class ReduceTest extends DataPrepareTest{
    
    private Integer[] l = new Integer[] {1,2,3,4,5};
    
    
    @Test
    public void shouldSumByReduce() {
     Integer result = Arrays.stream(l).reduce(0,(x,y)->x+y);
     assertThat(result).isEqualTo(15);
        
    }
    @Test
    public void shouldSumSalary() {
        BigDecimal sum = persons.stream().filter(Objects::nonNull).filter(p -> p.getSalary() != null).map(Person::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
        assertThat(sum).isEqualTo(new BigDecimal(54));
    }
    
    
}
