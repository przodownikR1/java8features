package pl.java.scalatech.optional.monad;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import lombok.Getter;
import lombok.Setter;



public class Insurance {
    @Getter
    @Setter
    private String name;

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
    }

    @Test
    public void test() {
        Person p = new Person();
        Optional<Person> po = Optional.of(p);

        Assertions.assertThat("Unknown").isEqualTo(getCarInsuranceName(po));

    }
}