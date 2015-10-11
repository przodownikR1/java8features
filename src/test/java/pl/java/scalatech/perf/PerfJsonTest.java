package pl.java.scalatech.perf;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.google.gson.Gson;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.guava.Customer;

@Slf4j
@AxisRange
@BenchmarkHistoryChart(filePrefix = "test-chart", maxRuns = 20)
public class PerfJsonTest {
    private Gson gson = new Gson();
    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    @Test
    @PerfTest(invocations = 50, threads = 5)
    @Required(average = 7, totalTime = 6000, percentile95 = 25)
    public void shouldMeasureJsonMarshalling() {
        String json = gson.toJson(Customer.builder().firstName("slawek").firstName("borowiec").salary(new BigDecimal(100)).build());
        log.info("{}", json);
    }

    @Test
    @PerfTest(invocations = 50, threads = 5)
    public void ordinaryLoop() {

        for (int i = 0; i < 100; i++) {
          compute(i);
        }

    }
    @Test
    @PerfTest(invocations = 50, threads = 5)
    public void newLoop() {

        IntStream.range(0, 100).forEach(l->compute(l));
    }

    @Test
    @PerfTest(invocations = 50, threads = 5)
    public void newParallelLoop() {

        IntStream.range(0, 100).parallel().forEach(l->compute(l));
    }


    @SneakyThrows
    private void compute(int i ) {
        Thread.sleep(5);
    }

}
