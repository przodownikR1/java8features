package pl.java.scalatech.pojo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * @author przodownik
 *         Module name : java8features
 *         Creating time : 14 maj 2014
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {

    private String name;
    private String login;
    private BigDecimal salary;
}
