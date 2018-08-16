package pl.java.scalatech.design_pattern.RepConwithPoly;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.design_pattern.RepConwithPoly.commonPart.Car;
import pl.java.scalatech.design_pattern.RepConwithPoly.commonPart.EngineType;
@Slf4j
@RunWith(value = Parameterized.class)
public class CarSpeedTest extends CommonCarTest{

   

    @Parameterized.Parameter(value = 0)
    public int num;
    @Parameterized.Parameter(value = 1)
    public int expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {180, 270},
                {200, 300},
                {210, 315}               
        });
    }
    @Test

    public void shouldCalculateForAllProcess(){
        Car car = Car.builder().engine(engines.get(EngineType.BITURBO)).normalSpeed(num).build();
        log.info("{}",car.maxSpeed());
        Assertions.assertThat(car.maxSpeed()).isEqualTo(expected);
    }
   
}
