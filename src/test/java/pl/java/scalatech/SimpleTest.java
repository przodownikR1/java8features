package pl.java.scalatech;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleTest {

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    // parallelStream() uses ForkJoinPool.common()
    @Test
    public void shouldCountAvailableProcessor() {
        log.info(" fork-join  : {} ,  availableProcessor : {} ", ForkJoinPool.commonPool().getParallelism(), Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void shouldListHiddenFiles() {
        File[] hiddenFiles = new File("/home/przodownik").listFiles(File::isHidden); // method reference
        log.info("+++ {}", Arrays.toString(hiddenFiles));
    }

}
