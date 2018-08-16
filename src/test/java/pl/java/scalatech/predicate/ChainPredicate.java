package pl.java.scalatech.predicate;

import static org.assertj.core.util.Lists.newArrayList;
import static pl.java.scalatech.Simple.builder;

import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.Simple;

@Slf4j
public class ChainPredicate {
    private List<Simple> simples = newArrayList(builder().name("przodownik").value(1).build(),
            builder().name("ssak").value(2).build(),
            builder().name("ptak").value(3).build(),
            builder().name("slawek").value(5).build(),
            builder().name("jacek").value(54).build());

    @Test
    public void shouldChainWork() {
        Predicate<Simple> p = o -> "slawek".equals(o.getName());

        Predicate<Simple> slawekOrValueGt3 = p.and(a -> a.getValue() > 3).or(p);

        simples.stream().filter(slawekOrValueGt3).forEach(l -> log.info("{}", l));
    }

}
