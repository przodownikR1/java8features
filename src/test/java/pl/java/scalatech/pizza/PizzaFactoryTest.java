package pl.java.scalatech.pizza;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class PizzaFactoryTest {
    @Test
    public void shouldOrderCreate(){
        
        Pizza pizza = new Pizza().makePie(PieType.black).addHam().addMashrums().addMozarella(new Cheese("Light")).executeOrder();
        log.info("pizza :  {}",pizza);                      
    }
    @Test
    public void shouldCloseContextLambda(){
        Pizza.make(p -> p.makePie(PieType.black).addHam().addMashrums().addMozarella(new Cheese("Light")).executeOrder());
    }
    
}
