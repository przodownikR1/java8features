package pl.java.scalatech.design_pattern.RepConwithPoly.newPolyApproach;

import static java.math.BigDecimal.valueOf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class EngineNew {

    private int capacity;
    private int ph;
    
    protected double calculateSpeed(int normalSpeed) {
        return valueOf(normalSpeed).multiply(valueOf((getMultiplier()))).doubleValue();
    }
    
    abstract double getMultiplier();
    
}
