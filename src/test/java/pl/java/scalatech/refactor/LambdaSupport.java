package pl.java.scalatech.refactor;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

public class LambdaSupport {
@Test
public void test(){
    List<String> strs = newArrayList("slawek","borowiec","14");
    strs.stream().forEach(new Consumer<String>(){

        @Override
        public void accept(String t) {
           System.err.println(t);
            
        }
        
    });
}
}
