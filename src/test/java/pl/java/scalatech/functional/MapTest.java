package pl.java.scalatech.functional;

import static org.fest.assertions.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.pojo.Person;
import pl.java.scalatech.timeTest.Timed;
import pl.java.scalatech.timeTest.TimedTest;

@Slf4j
public class MapTest extends DataPrepareTest {

    @Rule
    public TimedTest timeTest = new TimedTest();

    @Test
    @Timed(timeThreshold = 20)
    public void shouldSortNames() {
        List<String> sortNames = persons.stream().map(Person::getName).sorted().collect(Collectors.toList());
        assertThat(sortNames).containsExactly("aga", "kalina", "slawek", "slawek");
    }

    @Test
    public void shouldAllMatchWork() {
        List<String> sortNames = persons.stream().map(Person::getName).collect(Collectors.toList());
        boolean allMatch = sortNames.stream().allMatch(n -> n.length() > 2);
        assertThat(allMatch).isTrue();
    }

    @Test
    public void shouldBufferedReaderAsStream() throws IOException {
        assertThat(readAndConvertToPersonList("./src/test/resources/persons.csv")).hasSize(6).contains(new Person("slawek", "przodownik", new BigDecimal(110)));

    }

    private static List<Person> readAndConvertToPersonList(String pathName) throws IOException {
        List<Person> persons = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathName))))) {
            // stream -> br.lines()
            persons = br.lines().map(mapToPerson).collect(Collectors.toList());
        }
        return persons;
    }

    private static Function<String, Person> mapToPerson = (line) -> {
        String[] p = line.split(",");
        return new Person(p[0], p[1], new BigDecimal(p[2]));
    };

    @Test
    public void shouldSumSalaryForOnlyPersonWhenNameStartAtP() {
        log.info("++++ salary :  {}",
                persons.stream().filter(p -> p.getLogin().startsWith("p")).map(t -> t.getSalary()).reduce(BigDecimal.ZERO, BigDecimal::add));

    }

    @Test
    public void sumStream() {
        int sum = values.stream().mapToInt(value -> value).sum();
        log.info("{}", sum);
        assertThat(sum).isEqualTo(36);
    }

    @Test
    public void demonstrateDoubleSummaryStatisticsOnCollectionStream() {
        // given
        ImmutableMap<Integer, Double> sampler;

        Map<Integer, Double> temporary = Maps.newHashMap();
        temporary.put(1, 1.0);
        temporary.put(2, 2.1);
        temporary.put(3, 3.3);
        temporary.put(4, 4.66);
        temporary.put(5, 7.54);
        sampler = ImmutableMap.copyOf(temporary);
        // when
        final DoubleSummaryStatistics doubleSummaryStatistics = sampler.values().stream()
                .collect(DoubleSummaryStatistics::new, DoubleSummaryStatistics::accept, DoubleSummaryStatistics::combine);
        // then
        assertThat(doubleSummaryStatistics.getMax()).isEqualTo(7.54d);
        assertThat(doubleSummaryStatistics.getMin()).isEqualTo(1d);
        assertThat(doubleSummaryStatistics.getSum()).isEqualTo(18.6d);
        assertThat(doubleSummaryStatistics.getAverage()).isEqualTo(3.72d);
        log.info("samplerStatistics: {}", doubleSummaryStatistics);

    }

    @Test
    public void shouldDoubleSummaryStatisticsOnDoubleStreamEvaluate() {
        // given
        DoubleStream ds = DoubleStream.builder().add(1.1).add(2.2).add(3.3).build();
        // when
        DoubleSummaryStatistics dsStatistics = ds.summaryStatistics();
        // then
        assertThat(dsStatistics.getMax()).isEqualTo(3.3d);
        assertThat(dsStatistics.getMin()).isEqualTo(1.1d);
        assertThat(dsStatistics.getSum()).isEqualTo(6.6d);
        assertThat(dsStatistics.getAverage()).isEqualTo(2.1999999999999997d);
        log.info("Double Statistics: {}", dsStatistics);
    }

    @Test
    public void shouldLongSummaryStatisticsWork() {
        // given
        LongSummaryStatistics timeDurations = new LongSummaryStatistics();
        // when
        timeDurations.accept(50);
        timeDurations.accept(44);
        timeDurations.accept(4);
        // then
        assertThat(timeDurations.getMax()).isEqualTo(50);
        assertThat(timeDurations.getMin()).isEqualTo(4);
        assertThat(timeDurations.getSum()).isEqualTo(98);
        assertThat(timeDurations.getCount()).isEqualTo(3);
        log.info("long statistics {}", timeDurations);

    }
}
