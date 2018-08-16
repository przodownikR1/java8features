package pl.java.scalatech.design_pattern.RepConwithPoly.newPolyApproach;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class BiTurboEngine extends EngineNew{

    @Override
    double getMultiplier() {
        return 1.5d;
    }

}
