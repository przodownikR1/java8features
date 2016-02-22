package pl.java.scalatech.collection;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.pojo.Person;

@Slf4j
public class GroupingTest extends DataPrepareTest {

    @Test
    public void shouldGroupByLogin() {
        Map<String, List<Person>> result = persons.stream().collect(Collectors.groupingBy(Person::getLogin));

        log.info("{}", result);

        // Map<Person,List<Person>> result2 = persons.stream().collect(Collectors.groupingBy(Function.identity(),Person::getLogin));

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(groupingBy(Locale::getCountry, toSet()));
        log.info("countryToLocaleSet:{} ", countryToLocaleSet);
        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCounts = locales.collect(groupingBy(Locale::getCountry, counting()));
        log.info("{}", countryToLocaleCounts);
    }

}
