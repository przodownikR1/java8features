package pl.java.scalatech.foo;

import org.junit.Test;

import pl.java.scalatech.functional.foo.Bar;
import pl.java.scalatech.functional.foo.Foo;
import pl.java.scalatech.functional.foo.Printer;

public class FooTest {

    private Foo foo = Foo.getFoo();
    private Bar bar = Bar.getFoo();
    @Test
    public void shuoldFooWork() {
        foo.print();
    }
    
    @Test
    public void shouldlog(){
        bar.showLog(new Printer() {
            
            @Override
            public void log(String message) {
                System.err.println(message);
                
            }
        });
    }
}
