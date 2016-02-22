package pl.java.scalatech.mutable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MutableTest {

    @Test
    @SneakyThrows
    public void test() {
        Operation op = new Operation();
        ExecutorService es = Executors.newFixedThreadPool(100);

        List<Callable<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lst.add(() -> {
                log.info("Thread : {} : object : {}", Thread.currentThread().getName(),op.hashCode());
                return op.reset().add(1).add(2).multi(3).add(2).result();
            });
        }

        final List<Future<Integer>> task = es.invokeAll(lst);

        for (Future<Integer> callable : task) {
            log.info("{}", callable.get());

        }
        es.shutdown();
    }

}

class Operation {
    Integer state = 0;

    Operation add(Integer n) {
        this.state = this.state + n;
        return this;
    }

    public Operation reset() {
        this.state = 0;
        return this;
    }

    Operation multi(Integer n) {
        this.state = this.state * n;
        return this;
    }

    public Integer result() {
        return this.state;
    }

}