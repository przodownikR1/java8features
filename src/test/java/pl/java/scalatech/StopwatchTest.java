package pl.java.scalatech;

import lombok.extern.slf4j.Slf4j;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

@Slf4j
public class StopwatchTest {

    private static void logInfo(String testName, String status, long nanos) {
        log.warn(String.format("Test {}, {}, spent {} microseconds", testName, status, 1));
    }

    @Rule
    public Stopwatch stopwatch = new Stopwatch() {
        @Override
        protected void succeeded(long nanos, Description description) {
            logInfo(description.getMethodName(), "succeeded", nanos);
        }

        @Override
        protected void failed(long nanos, Throwable e, Description description) {
            logInfo(description.getMethodName(), "failed", nanos);
        }

        @Override
        protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
            logInfo(description.getMethodName(), "skipped", nanos);
        }

        @Override
        protected void finished(long nanos, Description description) {
            logInfo(description.getMethodName(), "finished", nanos);
        }

    };

    @Test
    public void succeeds1() {
    }

}