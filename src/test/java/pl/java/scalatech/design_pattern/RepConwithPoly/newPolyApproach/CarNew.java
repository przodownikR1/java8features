package pl.java.scalatech.design_pattern.RepConwithPoly.newPolyApproach;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Builder
@Data
@Slf4j
public class CarNew {
    private int normalSpeed;
    private EngineNew engine;
 
    public double maxSpeed() {
        return engine.calculateSpeed(normalSpeed);
        
    }
}
