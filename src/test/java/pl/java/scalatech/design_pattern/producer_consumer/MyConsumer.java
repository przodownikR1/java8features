package pl.java.scalatech.design_pattern.producer_consumer;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyConsumer<T> {

    private final BlockingQueue<T> queue;

    
    public void consume(Consumer<T> consumer) {
        try {
            consumer.accept(queue.take());

            MILLISECONDS.sleep(1250);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}