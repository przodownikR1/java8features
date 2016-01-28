package pl.java.scalatech.stream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.IntStream.range;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.pojo.Person;
@Slf4j
public class MapStreamTest extends DataPrepareTest{
    @Test
    public void shouldRetriveOnlyNames(){
       
        persons.remove(0);
        Map<Object,Object> personNames = persons.stream().collect(Collectors.toMap(Person::getLogin,Function.identity())); //(p)->p = identity
        
        Map<BigDecimal, String> collect = persons.stream().collect(Collectors.toMap(Person::getSalary, Person::getLogin));
        log.info("{}",collect);
        log.info("{}",personNames);
        
    }
    
    @Test
    public void map2() {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> result = locales.collect(
                Collectors.toMap(
                        (Locale l) -> l.getDisplayLanguage(),
                        (Locale l) -> l.getDisplayLanguage(l),
                        (existingValue, newValue) -> existingValue));

       log.info("{}",result);
    }

    @Test
    public void intStreamTest() {
        List<Integer> result = range(0, 10).boxed().collect(toCollection(ArrayList<Integer>::new));
        Assertions.assertThat(result.size()).isEqualTo(10);
    }
    
    
    
 
    
}
