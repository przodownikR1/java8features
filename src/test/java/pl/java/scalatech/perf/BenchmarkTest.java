package pl.java.scalatech.perf;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

import org.junit.Rule;
import org.junit.Test;

import pl.java.scalatech.guava.Customer;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import com.google.gson.Gson;

@AxisRange
@BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 5, callgc = false, concurrency = 4)
@Slf4j
@BenchmarkMethodChart(filePrefix = "barchart")
public class BenchmarkTest {
    private Gson gson = new Gson();
    @Rule
    public BenchmarkRule benchmarkRun = new BenchmarkRule();

    @BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 4)
    @Test
    public void test2() throws Exception {
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += "" + i;

        }
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 10)
    public void shouldMeasureJsonMarshalling() {
        String json = gson.toJson(Customer.builder().firstName("slawek").firstName("borowiec").salary(new BigDecimal(100)).build());
        log.info("{}", json);
    }

}
