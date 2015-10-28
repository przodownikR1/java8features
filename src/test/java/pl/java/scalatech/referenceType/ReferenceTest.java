package pl.java.scalatech.referenceType;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static pl.java.scalatech.Simple.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import javafx.geometry.Side;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.Simple;
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
    
    @Test
    public void shouldSupplierWork(){
        
        
        Supplier<Simple> simple = Simple::new;
        log.info("{}",simple.get());
        
        Supplier<Simple> simple1 = () -> new Simple("test",1);
        log.info("{}",simple1.get());

        BiFunction<String, Integer, Simple> simpleProducer = Simple::new;
        log.info("Simple :  {}",simpleProducer.apply("slawek", 34));
        assertThat(simpleProducer.apply("slawek", 34)).isEqualTo(Simple.builder().name("slawek").value(34).build());;

        Function<String, Simple> created = s -> new Simple(s);
        assertThat(created.apply("Kalina").getName()).isEqualTo("Kalina");
        
    }
    
    @Test
    public void simpleTest(){
        List<String> str = Arrays.asList("aaaa","bbbbb","AAAA","BBBBB","slawek");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
       
        str.sort(String::compareToIgnoreCase);
        
        String x = "sla";
        log.info("{}",str.stream().filter(c->c.contains(x)).findAny());
        
                     
    }
    
    @Test
    public void createObject(){
        List<String> names = Arrays.asList("A","B","C");
        List<Simple> simples = map(names, Simple::new);
        log.info("created : {}",simples);
        
    }
    public static List<Simple> map(List<String> list,Function<String, Simple> f){
        List<Simple> result = new ArrayList<>();
        for(String e: list){
        result.add(f.apply(e));
        }
        return result;
        }
    
    
    
    public interface TriFunction<T, U, V, R>{
        R apply(T t, U u, V v);
        }
    
    @Test
    public void shouldCreateSimpleBasedOnThreeArgs(){
        TriFunction<String, Integer, Boolean, Simple> s = Simple::new;
        log.info("{}",s.apply("slawek", 23, false));
    }
}
