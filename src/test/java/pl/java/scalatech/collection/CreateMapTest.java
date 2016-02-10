package pl.java.scalatech.collection;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Rule;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.pojo.Person;
import pl.java.scalatech.timeTest.TimedTest;
@Slf4j
public class CreateMapTest  extends DataPrepareTest 
{

    @Rule
    public TimedTest timeTest = new TimedTest();
    @Test
    public void shouldCreateMapLoginSalary(){
        Function<Person,BigDecimal> funSalary = p->p.getSalary();
        Function<Person,String> funLogin = p->p.getLogin();
        Map<String,BigDecimal> result = persons.stream().collect(Collectors.toMap(funLogin,funSalary));
        log.info(" {}",result);
    }
    @Test
    public void shouldSort(){
        List<Person> result = persons.stream().sorted((o1, o2) -> o1.getSalary().compareTo(o2.getSalary())).collect(Collectors.toList());
        log.info("{}",result);
    }
    
}
