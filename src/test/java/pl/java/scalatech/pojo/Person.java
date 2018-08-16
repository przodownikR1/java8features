package pl.java.scalatech.pojo;

import java.math.BigDecimal;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Person implements Comparator<Person> {

    private String name;
    private String login;
    private BigDecimal salary;

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getSalary().compareTo(o2.getSalary());
    }
}
