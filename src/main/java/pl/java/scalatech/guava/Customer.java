package pl.java.scalatech.guava;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sławomir Borowiec
 *         Module name : java8features
 *         Creating time : 7 kwi 2015 21:45:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    public enum Status {
        BUSY, LAZY, NEGATIVE
    }

    private BigDecimal salary;
    private String firstName;
    private String lastName;
    private Status status;

}
