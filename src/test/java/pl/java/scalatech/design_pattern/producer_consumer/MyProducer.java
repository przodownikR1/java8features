package pl.java.scalatech.design_pattern.producer_consumer;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MyProducer<T> {

    private final BlockingQueue<T> queue;

    public void produce(Supplier<T> supplier) {
        final T msg = supplier.get();
        try {
            queue.put(msg);
            log.info("Added message: {}", msg);
            MILLISECONDS.sleep(900);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}