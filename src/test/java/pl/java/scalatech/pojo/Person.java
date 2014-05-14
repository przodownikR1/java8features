package pl.java.scalatech.pojo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author przodownik
 *         Module name : java8features
 *         Creating time : 14 maj 2014
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    private String name;
    private String login;
    private BigDecimal salary;
}
