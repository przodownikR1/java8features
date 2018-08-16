package pl.java.scalatech.design_pattern.RepConwithPoly;

import java.util.Map;

import org.junit.Before;

import com.google.common.collect.Maps;

import pl.java.scalatech.design_pattern.RepConwithPoly.commonPart.EngineType;
import pl.java.scalatech.design_pattern.RepConwithPoly.old.Engine;

public abstract class CommonCarTest {
    
    protected Map<EngineType,Engine> engines  = Maps.newHashMap();
    @Before
    public void init(){
        engines.put(EngineType.ORDINARY, Engine.builder().capacity(1500).ph(90).type(EngineType.ORDINARY).build());
        engines.put(EngineType.BITURBO, Engine.builder().capacity(1500).ph(120).type(EngineType.BITURBO).build());
        engines.put(EngineType.PROSPORT, Engine.builder().capacity(1500).ph(130).type(EngineType.PROSPORT).build());
        engines.put(EngineType.SUPERSPORT, Engine.builder().capacity(1500).ph(140).type(EngineType.SUPERSPORT).build());
        engines.put(EngineType.TURBO, Engine.builder().capacity(1500).ph(100).type(EngineType.TURBO).build());
        
    }
}
