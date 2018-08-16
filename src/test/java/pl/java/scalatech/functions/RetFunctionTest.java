package pl.java.scalatech.functions;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.DataPrepareTest;

@Slf4j
public class RetFunctionTest extends DataPrepareTest {
    int hoursWorked = 10;

    @Test
    public void test2() {
        Function<String, String> toLowerFunction = String::toLowerCase;
        Consumer<String> consumer = s -> log.info("{}", toLowerFunction.apply(s));
        names.forEach(consumer);

    }

    @Test
    public void test1() {
        log.info("{}", X.calculatePay(10, 15.75f, X.EmployeeType.Hourly));
    }

    @Test
    public void test1Function() {

        log.info("{}", X.calculatePayFunction(X.EmployeeType.Hourly).apply(10, 15.75f));
        BiFunction<Integer, Float, Float> calculateFunction;
        if (hoursWorked <= 40) {
            calculateFunction = (hours, payRate) -> 40 * payRate;
        } else {
            calculateFunction = (hours, payRate) -> hours * payRate + (hours - 40) * 1.5f * payRate;
        }

        log.info("{}", calculateFunction.apply(hoursWorked, 15.57f));
    }

}

class X {
    static enum EmployeeType {
        Hourly, Salary, Sales
    };

    public static float calculatePay(int hourssWorked, float payRate, EmployeeType type) {
        switch (type) {

            case Hourly:
                return hourssWorked * payRate;
            case Salary:
                return 40 * payRate;
            case Sales:
                return 500.0f + 0.15f * payRate;
            default:
                return 0.0f;
        }
    }

    public static BiFunction<Integer, Float, Float> calculatePayFunction(EmployeeType type) {

        switch (type) {
            case Hourly:
                return (hours, payRate) -> hours * payRate;
            case Salary:
                return (hours, payRate) -> 40 * payRate;
            case Sales:
                return (hours, payRate) -> 500f + 0.15f * payRate;
            default:
                return null;
        }
    }
}
