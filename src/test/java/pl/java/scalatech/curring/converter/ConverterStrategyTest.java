package pl.java.scalatech.curring.converter;

import java.util.function.Function;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ConverterStrategyTest {
    @Test
    public void shouldConverterWork(){
        Converter converter = new Converter();
        double tenMilesInKm = converter.apply(1.609, 10.0);
        log.info("{}",converter.apply(1.609, 10.0));
        log.info("{}",converter.apply(1.609, 20.0));
        log.info("{}",converter.apply(1.609, 50.0));

        Function<Double, Double> mi2kmConverter = converter.curry1(1.609);
        log.info("{}",mi2kmConverter.apply(10.0));
        log.info("{}",mi2kmConverter.apply(20.0));
        log.info("{}",mi2kmConverter.apply(50.0));
    }
    
}
