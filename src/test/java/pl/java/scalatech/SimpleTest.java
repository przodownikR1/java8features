package pl.java.scalatech;

import java.util.concurrent.ForkJoinPool;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

@Slf4j
public class SimpleTest {
    // parallelStream() uses ForkJoinPool.common()
    @Test
    public void shouldCountAvailableProcessor() {
        log.info(" fork-join  : {} ,  availableProcessor : {} ", ForkJoinPool.commonPool().getParallelism(), Runtime.getRuntime().availableProcessors());

    }

}
