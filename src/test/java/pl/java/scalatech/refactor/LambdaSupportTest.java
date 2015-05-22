package pl.java.scalatech.refactor;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import com.google.common.collect.Lists;

public class LambdaSupportTest {
    @Test
    public void test() {
      Runnable r =   new Runnable() {

            @Override
            public void run() {
                System.err.println("todo");
            }
        };
        List<String> abs = Lists.newArrayList("a","b","c","d");
        abs.stream().forEach(new Consumer<String>() {

            @Override
            public void accept(String t) {
                       System.err.println(t);
                
            }
        });
    }
    
    
    
}
