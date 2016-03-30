package pl.java.scalatech.refMet;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserSpec {

    private String name;
    private int age;
    private BigDecimal salary;

    public UserSpec(String name, BigDecimal salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

}
