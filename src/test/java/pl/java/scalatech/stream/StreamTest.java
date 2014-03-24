package pl.java.scalatech.stream;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sławomir Borowiec 
 * Module name : java8features
 * Creating time :  24 mar 2014 13:45:39
 
 */
@Slf4j
public class StreamTest {
    List<Integer> values = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
    
    @Test
    public void sumStream(){
     int sum = values.stream().mapToInt(value  -> value).sum();
     log.info("{}",sum);
     Assertions.assertThat(sum).isEqualTo(36);
    }
}
