package pl.java.scalatech.collection;

import static java.math.BigDecimal.valueOf;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.pojo.Person;

@Slf4j
public class CollectorsTest extends DataPrepareTest {
    @Test
    public void test() {
        log.info("names {}", names);
        names.sort(comparingInt(n -> n.length()));

        names.sort(nullsLast(Comparator.comparingInt(n -> n.length())));

        names.sort(comparingInt((final String n) -> n.length()).thenComparing(naturalOrder()));
        log.info("+++ names {}", names);
    }

    @Test
    public void shouldFindMax() {
        Comparator<String> cmp = Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER);
        Optional<String> ret = persons.stream().map(s -> s.getLogin()).collect(Collectors.maxBy(cmp));
        log.info("++++ {}", ret);

    }

    @Test
    public void shouldComputeReduceMin() {

        Optional<String> longestName = names.stream().reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2);
        log.info("{}", longestName);
    }

    @Test
    public void shouldsummarizeBigDecimal() {
        BigDecimal sum1 = persons.stream().reduce(BigDecimal.ZERO, (bd, item) -> bd.add(item.getSalary()), BigDecimal::add);
        BigDecimal sum2 = persons.stream().filter(Objects::nonNull).map(Person::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
        Assertions.assertThat(sum1).isEqualByComparingTo(valueOf(54));
        Assertions.assertThat(sum2).isEqualByComparingTo(valueOf(54));
        BigDecimal sum3 = persons.stream().collect(Collectors.reducing(BigDecimal.ZERO,Person::getSalary,BigDecimal::add));
        Assertions.assertThat(sum3).isEqualByComparingTo(valueOf(54));
        Optional<BigDecimal> result = persons.stream().map(Person::getSalary).reduce(BigDecimal::add);
        Assertions.assertThat(result.get()).isEqualByComparingTo(valueOf(54));
        

    }
    @Test
    public void shouldJoinStrings(){
        log.info("joins {}",persons.stream().map(Person::getLogin).collect(Collectors.joining(" ")));
        
    }
}
