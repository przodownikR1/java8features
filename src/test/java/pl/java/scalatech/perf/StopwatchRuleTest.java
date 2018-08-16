package pl.java.scalatech.perf;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.guava.Customer;

@Slf4j
public class StopwatchRuleTest {
    private Gson gson = new Gson();
    /*
     * @Rule
     * @ClassRule
     * public static TestWatcher watcher = new TestWatcher() {
     * @Override
     * protected void starting(Description description) {
     * log.info("start : {}", description);
     * }
     * @Override
     * protected void finished(Description description) {
     * log.info("finish : {}", description);
     * }
     * };
     */

    @Rule
    public Stopwatch watch = new Stopwatch() {

        @Override
        protected void finished(long nanos, Description description) {
            log.info("method : {} , took : {}", description.getMethodName(), nanos);
        }
    };

    @Test
    public void test1() throws Exception {
        Thread.sleep(100);
    }

    @Test
    public void test2() throws Exception {
        String json = gson.toJson(Customer.builder().firstName("slawek").firstName("borowiec").salary(new BigDecimal(100)).build());
        log.info("{}", json);
    }

}