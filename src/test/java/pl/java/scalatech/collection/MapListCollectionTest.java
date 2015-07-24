package pl.java.scalatech.collection;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;

import pl.java.scalatech.common.DataPrepareTest;
import pl.java.scalatech.timeTest.TimedTest;

@Slf4j
public class MapListCollectionTest extends DataPrepareTest {
    @Rule
    public TimedTest timeTest = new TimedTest();

    @Test
    public void shouldRemoveAndReplace() {
        persons.removeIf(p -> p.getLogin().length() > 4);
        log.info("{}", persons);
        persons.replaceAll(t ->
        {
            t.setLogin(t.getLogin().toUpperCase());
            return t;
        });
        Assertions.assertThat(persons.size()).isEqualTo(2);
        log.info("{}", persons);
    }

    @Test
    public void shouldParallelPeek() {
        List<String> logins = persons.stream().parallel().peek(t ->
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
              
            }

        }).map(t -> t.getLogin()).collect(Collectors.toList());
        Assertions.assertThat(logins).contains("przodownik", "przodownik2", "poka", "bak");
    
    }

    @Test
    public void shouldSeqPeek() {

        List<String> logins = persons.stream().peek(t ->
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            
            }

        }).map(t -> t.getLogin()).collect(Collectors.toList());
        Assertions.assertThat(logins).contains("przodownik", "przodownik2", "poka", "bak");
    }

}
