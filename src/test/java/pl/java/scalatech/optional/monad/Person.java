package pl.java.scalatech.optional.monad;

import java.util.Optional;

import lombok.Getter;

public  class Person {
       @Getter
        private Optional<Car> car = Optional.of(new Car());
       
    }

    