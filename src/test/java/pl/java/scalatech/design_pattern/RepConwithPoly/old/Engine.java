package pl.java.scalatech.design_pattern.RepConwithPoly.old;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.design_pattern.RepConwithPoly.commonPart.EngineType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Engine {

    private int capacity;
    private EngineType type;
    private int ph;
}
