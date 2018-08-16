package pl.java.scalatech.design_pattern.RepConwithPoly.commonPart;

import static java.math.BigDecimal.valueOf;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.design_pattern.RepConwithPoly.old.Engine;
@Builder
@Data
@Slf4j
public class Car {

    private int normalSpeed;
    private Engine engine;

    public double maxSpeed() {
        
        double result = normalSpeed;
        switch (engine.getType()) {
            case BITURBO: {
                result = calculateSpeed(1.5d);
                break;
            }
            case ORDINARY: {
                result = calculateSpeed(1.0d);
                break;
            }
            case PROSPORT: {
                result = calculateSpeed(1.6d);
                break;
            }
            case SUPERSPORT: {
                result = calculateSpeed(1.8d);
                break;
            }
            case TURBO: {
                result = calculateSpeed(1.3d);
                break;
            }

        
        }
        return result;

    }

    private double calculateSpeed(double multiplier) {
        return valueOf(normalSpeed).multiply(valueOf((multiplier))).doubleValue();
    }
}
