package pl.java.scalatech.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntSupplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;

import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.pojo.Person;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

/**
 * @author Sławomir Borowiec
 *         Module name : java8features
 *         Creating time : 24 mar 2014 13:45:39
 */
@Slf4j
public class StreamTest extends DataPrepareTest {

    @Test
    public void shouldJoinAndToSetWork() {
        String names = persons.stream().map(Person::getName).collect(Collectors.joining(", "));
        Assertions.assertThat(names).isEqualTo("slawek, slawek, aga, kalina");

        Set<String> setOfPersons = persons.stream().map(Person::getName).collect(Collectors.toSet());
        Assertions.assertThat(setOfPersons).containsOnly("kalina", "slawek", "aga");
        Assertions.assertThat(setOfPersons).hasSize(3);

    }

    @Test
    public void shouldFilterNames() {
        List<Person> result = persons.stream().filter(p -> p.getName().equals("slawek")).collect(Collectors.toList());
        log.info(" +++ {}", result);

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

    private static List<String> filter(List<String> names, Predicate<String> condition) {
        return names.stream().filter((name) -> (condition.apply(name))).collect(Collectors.toList());

    }

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

    @Test
    public void shouldBuildStreamInt() {
        IntStream is = random.ints();
        log.info(" random stream :  {} ", "test");
        is.filter(i -> i < 100 && i > 0).limit(20).forEach(i -> log.info("{}", i));
    }

    @Test
    public void shouldBuildStream() {
        Stream<String> stream = Stream.<String> builder().add("yama").add("kawa").add("honda").add("suka").build();
        stream.forEach(moto -> log.info("{}", moto));
    }

    @Test
    public void shouldStreamIntCreate() {
        IntStream oneToFive = IntStream.rangeClosed(1, 6);
        oneToFive.forEach(i -> log.info("{}", i));
    }

    @Test
    public void shouldBuildSingleStream() {
        Stream<String> stringStream = Stream.of("moto");
        Assertions.assertThat(stringStream.findFirst().get()).isEqualTo("moto");
    }

    @Test
    public void shouldIterate() {
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);
    }

    @Test
    public void shouldPatternBuild() {
        Pattern pattrn = Pattern.compile(",");
        pattrn.splitAsStream("1,2,3,4").forEach(System.out::println);
    }

    @Test
    public void s() {
        Stream<String> stream = ThreadLocalRandom.current().longs().mapToObj(Long::toHexString).limit(5).sorted();
        Object[] sorted = stream.toArray();
        Assertions.assertThat(sorted).hasSize(5);
        log.info("{}", Arrays.toString(sorted));
    }
    

}
