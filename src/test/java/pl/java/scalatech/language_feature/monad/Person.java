package pl.java.scalatech.language_feature.monad;

import java.util.Optional;

import lombok.Getter;

public class Person {
    @Getter
    private Optional<Car> car = Optional.of(new Car());

}
