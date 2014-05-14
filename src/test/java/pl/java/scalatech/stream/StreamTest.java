package pl.java.scalatech.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;

import pl.java.scalatech.pojo.Person;

import com.google.common.collect.Lists;

/**
 * @author Sławomir Borowiec
 *         Module name : java8features
 *         Creating time : 24 mar 2014 13:45:39
 */
@Slf4j
public class StreamTest {
    private List<Integer> values = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
    private Random random = new Random();

    @Test
    public void sumStream() {
        int sum = values.stream().mapToInt(value -> value).sum();
        log.info("{}", sum);
        Assertions.assertThat(sum).isEqualTo(36);
    }

    @Test
    public void shouldBufferedReaderAsStream() throws FileNotFoundException {
        Assertions.assertThat(readAndConvertToPersonList("./src/test/resources/persons.csv")).hasSize(6)
                .contains(new Person("slawek", "przodownik", new BigDecimal(110)));

    }

    private static List<Person> readAndConvertToPersonList(String pathName) throws FileNotFoundException {
        InputStream is = new FileInputStream(new File(pathName));
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        List<Person> persons = br.lines().map(mapToPerson).collect(Collectors.toList());
        return persons;
    }

    private static Function<String, Person> mapToPerson = (line) -> {
        String[] p = line.split(",");
        BigDecimal salary = new BigDecimal(p[2]);
        return new Person(p[0], p[1], salary);
    };

    @Test
    public void shouldSortTable() {
        //given
        int[] ints = new int[1000];
        
        Arrays.parallelSetAll(ints, i -> random.nextInt(1000));
        //when
        Arrays.stream(ints).limit(10).forEach(i -> log.info("before sort:  {}", i));
        int sumBefore = Arrays.stream(ints).limit(20).sum();
        Arrays.parallelSort(ints);
        Arrays.stream(ints).limit(10).forEach(i -> log.info(" after sort : {}", i));
        int sumAfter = Arrays.stream(ints).limit(20).sum();
        
        //then
        Assertions.assertThat(sumAfter).isLessThan(sumBefore);
        
    }

}
