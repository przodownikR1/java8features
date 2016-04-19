package pl.java.scalatech.collection;

import static com.google.common.collect.Sets.newHashSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ComputeTest {

    Map<String,Integer> map = new HashMap<>();

    @Test
    public void functionTest() {
        Map<Integer, String> map = Maps.newHashMap();
        for (int i = 0; i < 3; i++) {
            map.putIfAbsent(i, "val " + i);
        }
        log.info("+++ {}",map);
    }

    @Test
    public <T> void computeTest() {
        Map<Integer, Set<Integer>> map = Maps.newHashMap();
        for (int i = 0; i < 3; i++) {
            map.putIfAbsent(i, newHashSet(1,2,3));
        }

        Set<Integer> result = map.merge(2, newHashSet(5,6),(t, u) -> {
            t.addAll(u);
            return t;
        });

        log.info("{}" ,map);
        log.info("result  {}",result);
    }

   @Test
   public void computeIfPresent(){
         Map<String,InnerContent> context=Maps.newHashMap();

         context.put("slawek", new InnerContent(1, 2, Sets.newHashSet(4,5,6)));


         context.computeIfPresent("slawek", (t, u) -> {
             u.setCount(u.getCount()+10);
             log.info(" t:  {} , u : {}", t, u);
             return u;
         });
         log.info("{}",context);

   }
   @Before
   public void setUp() throws Exception {
       map.put("Hello world", 9);
   }

   @Test
   public void testIfPresentCompute() throws Exception {
       map.computeIfAbsent("Test", String::length);
       System.out.println(map);
       map.computeIfPresent("Hello world", (k, v) -> v + k.length());
       System.out.println(map);
       map.compute("Hello", (k, v) -> v == null ? k.length() : v);
       System.err.println(map);
   }
}




