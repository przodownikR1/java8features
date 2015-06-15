package pl.java.scalatech.functional;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
@Slf4j
public class FunctionalTest {

    
    class ExampleAction implements Action{

        @Override
        public void print() {
           System.out.println("...example");
            
        }
        
    }
    
    @Test
    public void shouldPrint(){
        Action a = ()-> log.info("{}","sample test"); 
        a.print();
        a.defaultMethod();
        new ExampleAction().defaultMethod();
    }
}
