package pl.java.scalatech.stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class RangeTest {

    @Test
    public void shouldRangeStream() {
        IntStream.range(1, 10).forEach(l->log.info("{}",l));

        IntStream.range(0, 10).forEach(l->

        log.info("{} : {}",l,isPrime(l)));

    }

    private boolean isPrime(int n) {
        boolean flag = IntStream.range(2, n).noneMatch(l->n%2==0);
        return n>1 && flag;
    }

    
    @Test
    public void solution() throws Exception {
        List<Character> result = characterStream("Hello World").collect(Collectors.toList());
        assertThat(result).containsExactly('H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd');
    }

    private static Stream<Character> characterStream(String s) {
        return IntStream.rangeClosed(0, s.length() - 1).mapToObj(s::charAt);
    }
    
    @Test
    public void testIntStream() {
        List<Integer> output1 = IntStream.range(1, 2).boxed().collect(Collectors.toList());
        assertThat(output1).hasSize(1);

        List<Integer> output2 = IntStream.rangeClosed(1, 2).boxed().collect(Collectors.toList());
        assertThat(output2).hasSize(2);

    }
    
    @Test
    public void test2(){
    List<int[]> results =  IntStream.rangeClosed(1, 10).boxed().flatMap(a -> IntStream.rangeClosed(1, 10).mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a +b)})).collect(toList());
    results.forEach(a -> System.out.println(a[0] + ", " + a[1] + ", " + a[2]));
    }


}
