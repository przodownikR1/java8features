package pl.java.scalatech.apiTest;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.api.OrderApi;
import pl.java.scalatech.api.OrderApiImpl;
@Slf4j
public class DeliverApiTest {

    OrderApi api = new OrderApiImpl();
    
    @Test
    public void shouldFunctionalDeliverWork(){
        log.info("{}",api.oneClick(api.items));
    }
    
    
    
    
}
