package pl.java.scalatech.stream;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

public class CharSteamTest {

    @Test
    public void test(){
        List<String> words = Lists.newArrayList("slawek","borowiec","przodownik");
        int[] array = words.stream().flatMapToInt(String::chars).toArray();
        for(int i: array){
            System.out.println((char)i);
        }
        
        words.stream().flatMapToInt(String::chars).mapToObj(i->Character.toChars(i)).forEach( System.out::print );
    }
    
}
