package rx;

import org.junit.Test;

public class RxTest {
    @Test
    public void test2() {
        Observable.from(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 7 })
                .filter(i -> i > 2)
                .toList()
                .subscribe(System.out::println);

    }

    @Test
    public void test3() {
        Observable.just("a", "b", "c", "d", "e", "f")
                .window(2, 2)
                .subscribe(stringObservable -> {
                    System.out.println("stringObservable = " + stringObservable);
                    stringObservable.subscribe(s -> System.out.println("s = " + s));
                });
    }

}
