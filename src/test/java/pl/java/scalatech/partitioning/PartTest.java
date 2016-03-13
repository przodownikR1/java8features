package pl.java.scalatech.partitioning;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class PartTest {

    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(1, 5, 2, 5, 7, 9, 3);

        Map<Boolean, List<Integer>> collect = numbers.stream().collect(partitioningBy(number -> number == 5));

        System.out.println(collect);
    }

    @Test
    public void grouping() {
        List<Integer> numbers = Arrays.asList(1, 5, 2, 5, 7, 9, 3);
        
        

        Map<Boolean, List<Integer>> collect = numbers.stream().collect(groupingBy(number -> number > 4));
        System.out.println(collect);
        
        List<Integer> number1 = Arrays.asList(1,5,5,9, 3);
        Map<Integer, List<Integer>> collect1 = number1.stream().collect(groupingBy(number -> number + 5));
        log.info("{}",collect1);  
    }
}
