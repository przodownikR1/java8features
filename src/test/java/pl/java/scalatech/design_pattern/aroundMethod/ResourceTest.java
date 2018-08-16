package pl.java.scalatech.design_pattern.aroundMethod;

import org.junit.Test;

public class ResourceTest {

    @Test
    public void shouldExecuteAroundPatternTest(){
        Resource.use(re->re.operationOne().operationTwo());
    }
}
