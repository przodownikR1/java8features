package pl.java.scalatech.predicate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factor {

    private long id;
    private String name;
    private Process state;
    
}
