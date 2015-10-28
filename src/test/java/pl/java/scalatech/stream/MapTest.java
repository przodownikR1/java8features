package pl.java.scalatech.stream;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class MapTest {
   
    List<String> strs = newArrayList("slawek","aga","kalina","tomek");
    @Test
    public void mapTest(){
        List<Integer> strsLength = strs.stream()
                .map(String::toLowerCase)
                .map(String::length)
                .collect(toList() );
        log.info("{}",strsLength);
    }
    
    @Test
    public void shouldStreamFromStreamTest(){
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        List<String> s = streamOfwords
        .map(word -> word.split(""))
        .flatMap(Arrays::stream)//here return Stream<String> -> flat required
        .distinct()
        .collect(toList());
        log.info("{}",s);
        
    }
    
}
