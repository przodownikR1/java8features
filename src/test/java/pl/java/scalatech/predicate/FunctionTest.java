package pl.java.scalatech.predicate;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class FunctionTest {

    Db db = new Db();
    UpdateStatus us ;
    
@Before
    public void init(){
    db.getFactors().addAll(Lists.newArrayList(new Factor(1,"slawek",Process.START),
            new Factor(2,"przodownik",Process.START),
            new Factor(3,"karol",Process.START)));
    us = new UpdateStatusImpl(db);
    }
    
    
    @Test
    public void shouldStatusStateWork(){ 
        BiFunction<Factor, Process ,Factor> flow = (f,p) -> us.updateStatus(f.getId(), Process.START); 
       
        db.getFactors().stream();;
        
    }
    
}
