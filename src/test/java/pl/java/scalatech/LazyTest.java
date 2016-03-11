package pl.java.scalatech;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LazyTest {

    public static boolean isEven(int n) {
        log.info("isEven: {}", n);
        return n % 2 == 0;
    }

    public static int doubleIt(int n) {
        log.info("doubleIt: ", n);
        return n * 2;
    }

    public static boolean isGreatThan5(int n) {
        log.info("isGT5: ", n);
        return n > 5;
    }

    @Test
    public void shouldLazyWork() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5, 6);

        for (int n : numbers) {
            if (n % 2 == 0) {
                int n2 = n * 2;
                if (n2 > 5) {
                    log.info("imperative style : {}", n2);
                    break;
                }
            }
        }

        List<Integer> l1 = new ArrayList<>();
        for (int n : numbers) {
            if (isEven(n)) l1.add(n);
        }

        List<Integer> l2 = new ArrayList<>();
        for (int n : l1) {
            l2.add(doubleIt(n));
        }

        List<Integer> l3 = new ArrayList<>();
        for (int n : l2) {
            if (isGreatThan5(n)) l3.add(n);
        }

        log.info("imperative seq : {}", l3.get(0));

        log.info("declarative style : {}", numbers.stream().filter(LazyTest::isEven).map(LazyTest::doubleIt).filter(LazyTest::isGreatThan5).findFirst().get());
    }
}
