
package pl.java.scalatech.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class ReusingStreamTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void shouldReusingStreamAgainTest() {
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok

    }
    
   @Test    
    public void shouldThrowException(){
        Stream<String> stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                    .filter(s -> s.startsWith("a"));
            exception.expect(IllegalStateException.class);
            exception.expectMessage("stream has already been operated upon or closed");
            stream.anyMatch(s -> true);    // ok
            stream.noneMatch(s -> true);   // exception

    }
}
