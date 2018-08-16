package pl.java.scalatech.normalOrder;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NormalOrderTest {
    List<Integer> lists = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static int add(int x, int y) {
        log.info("++ add");
        return x + y;
    }

    public static int evaluate(int x) {
        log.info("evaluate");
        return x;

    }

    public static int evaluate2(int x) {
        log.info("evaluate");
        return 42;
    }

    @Test
    public void testOrder() {
        log.info("order :  {}", evaluate(add(1, 2)));

    }

    @Test
    public void testOrder2() {
        log.info("order 2 : {}", evaluate2(add(1, 2)));
    }

    @Test
    public void lazyTest() {
        add(1, 2);
    }

    @Test
    public void java8OldTest() {
        int result = 0;
        for (int i : lists) {
            if (i > 3 && i % 2 == 0) {
                result = i * 2;
                break;
            }
        }
        log.info("old fashioned {}", result);
    }

    @Test
    public void javaCountTest() {
        int result = 0;
        for (int i : lists) {
            if (greatThen3(i) && even(i)) {
                result = doubleIt(i);
                break;
            }
        }
        log.info("old fashioned {}", result);
    }

    @Test
    public void java8OldTest2() {
        lists = Lists.newArrayList();
        int result = 0;
        for (int i : lists) {
            if (i > 3 && i % 2 == 0) {
                result = i * 2;
                break;
            }
        }
        log.info("old fashioned {}", result);
    }

    @Test(expected = NullPointerException.class)
    public void java8OldTest3() {
        lists = null;
        int result = 0;
        for (int i : lists) {
            if (i > 3 && i % 2 == 0) {
                result = i * 2;
                break;
            }
        }
        log.info("old fashioned {}", result);
    }

    @Test
    public void java8Approach() {
        Optional<Integer> result = lists.stream().filter(i -> i > 3).filter(i -> i % 2 == 0).map(i -> i * 2).findFirst();
        if (result.isPresent()) {
            log.info("optional: {}", result.get());
        }
    }

    @Test
    public void java8ApproachExplaination() {
        Optional<Integer> result = lists.stream().filter(NormalOrderTest::greatThen3).filter(NormalOrderTest::even).map(NormalOrderTest::doubleIt).findFirst();
        if (result.isPresent()) {
            log.info("optional: {}", result.get());
        }
    }

    @Test
    public void java8ApproachExplainationWithOutClosed() {
        lists.stream().filter(NormalOrderTest::greatThen3).filter(NormalOrderTest::even).map(NormalOrderTest::doubleIt);

    }

    public static boolean greatThen3(int x) {
        log.info("greatThen3 {}", x);
        return x > 3;
    }

    public static boolean even(int x) {
        log.info("even {}", x);
        return x % 2 == 0;
    }

    public static int doubleIt(int x) {
        log.info("doubleIt {}", x);
        return x = x * 2;
    }

    @Test
    public void testOrder3() {
        int value = 4;
        if (value > 4 && add(1, 2) > 2) {
            log.info("+++ one");

        } else {
            log.info("+++ two");
        }
    }

    @Test
    public void testOrder4() {
        int value = 4;
        int temp = add(1, 2);
        if (value > 5 && temp > 4) {
            log.info("order4 +++ one");

        } else {
            log.info("order 4 +++ two");
        }
    }

}
