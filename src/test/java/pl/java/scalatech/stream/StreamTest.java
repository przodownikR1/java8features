package pl.java.scalatech.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import pl.java.scalatech.pojo.Person;

import com.google.common.base.Predicate;
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

    List<Person> persons;

    @Before
    public void init() {
        persons = Lists.newArrayList(new Person("slawek", "przodownik", new BigDecimal(11)), new Person("slawek", "przodownik2", new BigDecimal(11)),
                new Person("aga", "poka", new BigDecimal(12)), new Person("kalina", "bak", new BigDecimal(123)));
    }

    @Test
    public void shouldSumSalaryForOnlyPersonWhenNameStartAtP() {
        log.info("++++ salary :  {}",
                persons.stream().filter(p -> p.getLogin().startsWith("p")).map(t -> t.getSalary()).reduce(BigDecimal.ZERO, BigDecimal::add));

    }

    @Test
    public void sumStream() {
        int sum = values.stream().mapToInt(value -> value).sum();
        log.info("{}", sum);
        Assertions.assertThat(sum).isEqualTo(36);
    }

    @Test
    public void shouldBufferedReaderAsStream() throws IOException {
        Assertions.assertThat(readAndConvertToPersonList("./src/test/resources/persons.csv")).hasSize(6)
                .contains(new Person("slawek", "przodownik", new BigDecimal(110)));

    }

    @Test
    public void shouldFilterNames() {
        List<Person> result = persons.stream().filter(p -> p.getName().equals("slawek")).collect(Collectors.toList());
        log.info(" +++ {}", result);

    }

    @Test
    public void shouldSortNames() {
        List<String> sortNames = persons.stream().map(Person::getName).sorted().collect(Collectors.toList());
        Assertions.assertThat(sortNames).containsExactly("aga", "kalina", "slawek", "slawek");
    }

    @Test
    public void shouldFilterLengthWork() {
        List<String> languages = Lists.newArrayList("java", "c#", "perl", "fortran");
        Assertions.assertThat(filter(languages, s -> (s.length() > 3))).containsExactly("java", "perl", "fortran");
    }

    @Test
    public void shouldExplictLenghtFilterWork() {
        Predicate<String> greaterThanThree = (n) -> n.length() > 3;
        List<String> languages = Lists.newArrayList("java", "c#", "perl", "fortran");
        Assertions.assertThat(filter(languages, greaterThanThree)).containsExactly("java", "perl", "fortran");

    }

    private static List<Person> readAndConvertToPersonList(String pathName) throws IOException {
        List<Person> persons = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathName))))) {
            persons = br.lines().map(mapToPerson).collect(Collectors.toList());
        }
        return persons;
    }

    private static List<String> filter(List<String> names, Predicate<String> condition) {
        return names.stream().filter((name) -> (condition.apply(name))).collect(Collectors.toList());

    }

    private static Function<String, Person> mapToPerson = (line) -> {
        String[] p = line.split(",");
        return new Person(p[0], p[1], new BigDecimal(p[2]));
    };

    @Test
    public void shouldSortTable() {
        // given
        int[] ints = new int[1000];

        Arrays.parallelSetAll(ints, i -> random.nextInt(1000));
        // when
        // Arrays.stream(ints).limit(10).forEach(i -> log.info("before sort:  {}", i));
        int sumBefore = Arrays.stream(ints).limit(20).sum();
        Arrays.parallelSort(ints);
        // Arrays.stream(ints).limit(10).forEach(i -> log.info(" after sort : {}", i));
        int sumAfter = Arrays.stream(ints).limit(20).sum();

        // then
        Assertions.assertThat(sumAfter).isLessThan(sumBefore);

    }

    @Test
    public void shouldReduceWork() {
        List<String> digitals = Lists.newArrayList("1", "2", "3", "4");
        String result = digitals.stream().reduce("AS-", String::concat);
        log.info("{}", result);
    }

    @Test
    public void shouldReduceNumberWork() {
        List<Integer> digitals = Lists.newArrayList(1, 2, 3, 4);
        int sum = digitals.stream().reduce(0, Integer::sum);
        log.info("{}", sum);
    }

    @Test
    public void e() {
        Stream<Date> stream = Stream.generate(() -> {
            return new Date();
        });
        log.info("{}", stream.findFirst().get());
    }

    @Test
    public void shouldRangeWork() {
        Stream.generate(Math::random).limit(10).forEach(d -> log.info("{},d"));
    }

    @Test
    public void shouldfibGenerate() {
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(d -> log.info("{}", d));
    }

}
