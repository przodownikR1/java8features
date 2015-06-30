package pl.java.scalatech.functional;

import static org.fest.assertions.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;

import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.pojo.Person;
@Slf4j
public class MapTest extends DataPrepareTest{
    
    @Test
    public void shouldSortNames() {
        List<String> sortNames = persons.stream().map(Person::getName).sorted().collect(Collectors.toList());
        assertThat(sortNames).containsExactly("aga", "kalina", "slawek", "slawek");
    }
    
    
    
    
   @Test
    public void shouldAllMatchWork() {
       List<String> sortNames = persons.stream().map(Person::getName).collect(Collectors.toList());
       boolean allMatch =
               sortNames.stream().allMatch(n -> n.length() > 2) ;
       assertThat(allMatch).isTrue();
    }
    
    
    @Test
    public void shouldBufferedReaderAsStream() throws IOException {
        Assertions.assertThat(readAndConvertToPersonList("./src/test/resources/persons.csv")).hasSize(6)
                .contains(new Person("slawek", "przodownik", new BigDecimal(110)));

    }
    
    private static List<Person> readAndConvertToPersonList(String pathName) throws IOException {
        List<Person> persons = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathName))))) {
            //stream -> br.lines()
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
        Assertions.assertThat(sum).isEqualTo(36);
    }

}
