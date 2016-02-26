package pl.java.scalatech.closeResource;

import org.junit.Test;

public class ResourceTest {

    @Test
    public void shouldExecuteAroundPatternTest(){
        Resource.use(re->re.operationOne().operationTwo());
    }
}
