package pl.java.scalatech.mutable;

import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.concurrent.Executors.newFixedThreadPool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.junit.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorTest {
    @Test
    public void shouldExecutorWork() {
        ExecutorService executorService = newFixedThreadPool(10);
        List<Future<String>> futures = new ArrayList<>();
        Callable<String> callable = new Task();               
        for (int i = 0; i < 50; i++) {
            futures.add(executorService.submit(callable));
        }        
        for (Future<String> fut : futures) {
            try {
                log.info("{} , {}", now().format(ofPattern("mm:ss .SSS")), fut.get());
            } catch (InterruptedException | ExecutionException e) {
            }
        }
        executorService.shutdown();
    }
    @Test
    @SneakyThrows    
    public void shouldExecutoInvokeAllVersionrWork(){
        ExecutorService executorService = newFixedThreadPool(10);
        List<Callable<String>> lst = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            lst.add(new Task());
        }
        final List<Future<String>> task = executorService.invokeAll(lst);    
        for (Future<String> callable : task) {
            log.info("+++ {}", callable.get());

        }
    }
    
    
}
