package pl.java.scalatech.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RevertList {
    @Test
    public void convert() {
        List<String> s = Lists.newArrayList("slawek", "bak", "kalina");
        s.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator().forEachRemaining(l->log.info("{}",l));
        Iterator<String> result = s.stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator();
        log.info("{}", Lists.newArrayList(result));
        

    }
}
