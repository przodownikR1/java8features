package pl.java.scalatech.functions;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Test;

public class EliminatedependencyTest {

    BiFunction<Integer, Double, Double> computeHourly = (hours, rate) -> hours * rate;
    Function<Double, Double> computeSalary = rate -> rate * 40.0;
    BiFunction<Double, Double, Double> computeSales = (rate, commission) -> rate * 40.0 + commission;

    @Test
    public void test() {
        System.out.println(computeHourly.apply(35, 12.75)
                + computeSalary.apply(25.35)
                + computeSales.apply(8.75, 2500.0));
    }

}
