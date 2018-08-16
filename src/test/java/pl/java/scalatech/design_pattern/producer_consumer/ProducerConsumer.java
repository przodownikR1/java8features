package pl.java.scalatech.design_pattern.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ProducerConsumer {
 
    private static final int MSGS = 10; 
    private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(MSGS);
 
    public static void main(String[] args) {
        new ProducerConsumer().startEngine();
    }
 
    public void startEngine() {
        startProducer();
        startConsumer();
    }
  
    private void startProducer() { 
        new Thread(() -> {
            for (int i = 0; i < MSGS; i++) {
                new MyProducer<>(queue).produce(() -> "Hello World");
            }
        }).start();
    }
 
    private void startConsumer() { 
        new Thread(() -> {
            for (int i = 0; i < MSGS; i++)
                new MyConsumer<>(queue).consume((s) -> log.info("Consumed message: {}", s));
        }).start();
    }
          
}