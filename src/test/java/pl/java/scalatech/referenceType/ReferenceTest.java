package pl.java.scalatech.referenceType;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static pl.java.scalatech.referenceType.Simple.builder;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ReferenceTest {

    private List<Simple> simples = newArrayList(builder().name("przodownik").value(1).build(),
            builder().name("ssak").value(2).build(),
            builder().name("ptak").value(3).build()); 
    
    @Test
    public void shouldReferenceWork(){
       assertThat(simples.stream().map(t->t.getValue()).collect(toList())).containsExactly(1,2,3);
       assertThat(simples.stream().map(Simple::getValue).collect(toList())).containsExactly(1,2,3);
       log.info("{}",simples.stream().map(Simple::getName).collect(toList()));
       
       List<String> str = asList("a","b","A","B");
       str.sort(String::compareToIgnoreCase);
       log.info("sort : {}",str);
     
       Function<String, Integer> stringToInteger = Integer::parseInt;
       assertThat(stringToInteger.apply("12")).isEqualTo(12);
       
       
       BiPredicate<List<String>, String> contains = List::contains;
       assertThat(contains.test(str, "B")).isTrue();
       
       BiFunction<String, Integer, Simple> simpleProducer = Simple::new;
       log.info("Simple :  {}",simpleProducer.apply("slawek", 34));
       assertThat(simpleProducer.apply("slawek", 34)).isEqualTo(Simple.builder().name("slawek").value(34).build());
       
       
       
    }
   
}
