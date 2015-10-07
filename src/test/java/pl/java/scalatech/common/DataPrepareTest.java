package pl.java.scalatech.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.assertj.core.util.Maps;
import org.junit.Before;

import pl.java.scalatech.pojo.Person;

import com.google.common.collect.Lists;

public abstract class DataPrepareTest {
    protected List<Person> persons;
    protected List<Integer> values = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
    protected Map<Integer,Person> maps = Maps.newHashMap();
    protected Random random = new Random();
    protected List<String> names = Lists.newArrayList("slawek", "bak", "agnieszka", "slawek", "bak", "bak", "tyson");

    @Before
    public void init() {
        persons = Lists.newArrayList(new Person("slawek", "przodownik", new BigDecimal(12)), new Person("slawek", "przodownik2", new BigDecimal(23)),
                new Person("aga", "poka", new BigDecimal(6)), new Person("kalina", "bak", new BigDecimal(13)));
        maps.put(1, new Person("slawek", "przodownik", new BigDecimal(12)));
        maps.put(2,  new Person("slawek", "przodownik2", new BigDecimal(23)));
        maps.put(3, new Person("aga", "poka", new BigDecimal(6)));
        maps.put(4, new Person("kalina", "bak", new BigDecimal(13)));
    }
}
